import glob

test_filenames = glob.glob("./tests/*")
jflap_begin = r'<?xml version="1.0" encoding="UTF-8" standalone="no"?><!--Created with JFLAP 7.1.--><structure>&#13;<type>fa</type>&#13;<automaton>&#13;'
jflap_end = r'</automaton>&#13;</structure>'

def create_state(id, name, x_coord, y_coord, is_initial, is_final):
    return f"""
                <state id="{id}" name="{name}">&#13;
                    <x>{x_coord}</x>&#13;
                    <y>{y_coord}</y>&#13;
                    {'<initial/>&#13;' if is_initial else ''}
                    {'<final/>&#13;' if is_final else ''}
                </state>&#13;
            """

def create_transition(from_state, to_state, on_symb):
    return f"""
                <transition>&#13;
			        <from>{from_state}</from>&#13;
			        <to>{to_state}</to>&#13;
			        <read>{on_symb}</read>&#13;
		        </transition>&#13;
            """

def test_file_data(test_filename):
    with open(test_filename) as file:
        data = file.readlines()

        for i in range(len(data)):
            data[i] = data[i].replace('\n', '')

    final_states = data[0].split(' ')
    start_states = data[1].split(' ')
    other_states = data[2].split(' ')
    transitions = data[3].split(' ')
    input_strings = data[4:]

    return {
        'final_states': final_states,
        'start_states': start_states,
        'other_states': other_states,
        'transitions': transitions,
        'input_strings': input_strings
    }

def create_jflap_file(test_filename):
    data = test_file_data(test_filename)
    jflap_filename = test_filename.replace('.txt', '_jflap.jff')
    state_id_init = 0
    x_coord_init = 12.0
    x_coord_offset = 60.0
    y_coord_init = 24.0
    state_ids = {

    }

    jflap_states = []
    for state in data['final_states']:
        is_also_initial = True if state in data['start_states'] else False
        if is_also_initial:
            data['start_states'].remove(state)
        if state:
            state_ids[state] = state_id_init
            jflap_states.append(create_state(state_id_init, state, x_coord_init, y_coord_init, is_also_initial, True))
            state_id_init += 1
            x_coord_init += x_coord_offset

    for state in data['start_states']:
        if state:
            state_ids[state] = state_id_init
            is_also_final = True if state in data['final_states'] else False
            jflap_states.append(create_state(state_id_init, state, x_coord_init, y_coord_init, True, is_also_final))
            state_id_init += 1
            x_coord_init += x_coord_offset

    for state in data['other_states']:
        if state:
            state_ids[state] = state_id_init
            jflap_states.append(create_state(state_id_init, state, x_coord_init, y_coord_init, False, False))
            state_id_init += 1
            x_coord_init += x_coord_offset

    jflap_transitions = []
    for transition in data['transitions']:
        if transition:
            from_state, on_symb, to_state = [*transition]
            jflap_transitions.append(create_transition(state_ids[from_state], state_ids[to_state], on_symb))

    with open(jflap_filename, 'w+') as file:
        file.write(jflap_begin)
        file.write('\n')
        file.write('\n'.join(jflap_states))
        file.write('\n')
        file.write('<!--The list of transitions.-->&#13;')
        file.write('\n'.join(jflap_transitions))
        file.write(jflap_end)

for filename in test_filenames:
    if '.txt' in filename:
        create_jflap_file(filename)