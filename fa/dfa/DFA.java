package fa.dfa;

import fa.State;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Simulates a DFA by implementing the DFA interface.
 * It works by performing the following services for the DFA:
 * Storing states including start/final
 * Storing DFA alphabet
 * Storing transitions into each DFA state
 * Determining if a string is in the DFA's language
 * Outputting DFA 5-tuple to string
 * 
 * @author Drew Marshall
 * @author Steven Lineses
 */
public class DFA implements DFAInterface {

    //Need to instantiate the 5-tuple with variables to hold values
    private LinkedHashSet<DFAState> states; //states = Q = all states
    private LinkedHashSet<DFAState> finalStates; // finalStates = F = final states (if any)
    private LinkedHashSet<Character> sigma; //sigma = alphabet 
    private DFAState startState; //startState = q0 = starting state
    private boolean hasFinalState = false; // Used to check if DFA has at least one final state

    public DFA() {
        states = new LinkedHashSet<>();
        finalStates = new LinkedHashSet<>();
        sigma = new LinkedHashSet<>();
        startState = null;
    }

    /**
	 * Adds the initial state to the DFA instance
	 * @param name is the label of the start state
	 */
    @Override
    public void addStartState(String name) {
        //Need to check if the startState has already
        //been entered somewhere else
        //if not we can just initialize it and add it
        for(DFAState s: states) {
            String stateName = s.getName();
            if(stateName.equals(name)) { //Start state is already in states so we just have to update it
                startState = s;
            }       
        }

        if(startState == null) {
            startState = new DFAState(name);
            states.add(startState);
        }
    }

    /**
	 * Adds a non-final, not initial state to the states set
	 * @param name is the label of the state 
	 */
    @Override
    public void addState(String name) {
        DFAState state = new DFAState(name);
        states.add(state);
    }

    /**
	 * Adds a final state to the FinalStates set
	 * @param name is the label of the state
	 */
    @Override
    public void addFinalState(String name) {
        DFAState fState = new DFAState(name);
        finalStates.add(fState);
        states.add(fState);
        hasFinalState = true;
    }

    /**
	 * Adds the transition to the sigma set, otherwise known as constructing the alphabet
	 * @param fromState is the label of the state where the transition starts
	 * @param onSymb is the symbol from the DFA's alphabet.
	 * @param toState is the label of the state where the transition ends
	 */
    @Override
    public void addTransition(String fromState, char onSymb, String toState) {
        DFAState stateFrom = null;
        DFAState stateTo = null;

        // Get required states from DFA.
        stateFrom = getState(fromState);
        stateTo = getState(toState);

        // Ensure that both the from and to states in a transition exist in the DFA's states.
        if (stateFrom != null && stateTo != null) {
            stateFrom.insertTrans(onSymb, stateTo);
        }

        // Check if character exists in alphabet and add it if it doesn't.
        boolean flag = false;
        for(Character c: sigma) {
            if(c.equals(onSymb)) {
                flag = true;
            }
        }

        if(!flag) {
            sigma.add(onSymb);
        }
    }

    /**
	 * Getter for Q
	 * @return a set of states that DFA has
	 */
    @Override
    public Set<? extends State> getStates() {
        return states;
    }

    /**
	 * Getter for F
	 * @return a set of final states that DFA has
	 */
    @Override
    public Set<? extends State> getFinalStates() {
        return finalStates;
    }

    /**
	 * Getter for q0
	 * @return the start state of DFA
	 */
    @Override
    public State getStartState() {
        return startState;
    }

    /**
	 * Getter for Sigma
	 * @return the alphabet of DFA
	 */
    @Override
    public Set<Character> getABC() {
        return sigma;
    }

    /**
	 * Simulates a DFA on input s to determine
	 * whether the DFA accepts s.
	 * @param s - the input string
	 * @return true if s in the language of the DFA and false otherwise
	 */
    @Override
    public boolean accepts(String s) {
        // If DFA has no final states, then any input is rejected.
        if (!hasFinalState) {
            return false;
        }

        boolean emptyFlag = false;
        if(s.equals("e")){
            emptyFlag = true;
        }
        // Split `s` into separate chars for iteration.
        char[] inputChars = s.toCharArray();

        // Start at start state
        DFAState curr = startState;

        // Following conditions must be met in order for DFA to accept empty string.
        if(emptyFlag && isFinalState(curr)) {
            return true;
        }

        for(char inputChar : inputChars) {
            // Transition to next state based on transition table.
            curr = getToState(curr, inputChar);
            
            // If curr state is null, then that means the transition is not valid.
            if (curr == null) {
                return false;
            }
        }

        // Determine if DFA in final state.
        return isFinalState(curr);
    }

    /**
     * Checks if the provided state is a final state.
     * 
     * @param state The state to check if it is a final state
     * @return True if state is final else false
     */
    private boolean isFinalState(State state) {
        return finalStates.contains(state);
    }

    /**
     * Get DFA state based on DFA state name.
     * 
     * @param state The state to retrieve from the DFAs existing states
     * @return DFA state if one exists with the provided state name
     */
    private DFAState getState(String state){
        DFAState retState = null;
        for(DFAState s: states){
            String stateName = s.getName();
            if(stateName.equals(state)){
                retState = s;
            }
        }
        return retState;
    }

    /**
	 * Uses transition function delta of FA
     * 
	 * @param from The source state
	 * @param onSymb The label of the transition
	 * @return The sink state.
	 */
    @Override
    public DFAState getToState(DFAState from, char onSymb) {
        return from.getTrans().get(onSymb);
    }
    
    /**
	 * Construct the textual representation of the DFA, for example
	 * A simple two state DFA
	 * Q = { a b }
	 * Sigma = { 0 1 }
	 * delta =
	 *			0	1	
	 *		a	a	b	
	 *		b	a	b	
	 * q0 = a
	 * F = { b }
	 * 
	 * The order of the states and the alphabet is the order
	 * in which they were instantiated in the DFA.
     * 
	 * @return String representation of the DFA
	 */
    public String toString() {
        String retString = "";
        retString += "Q = { ";

        //Add each state from the states set
        for(DFAState s: states){
            retString += s.getName() + " ";
        }

        retString += "}\nSigma = { ";

        //Add each character from the alphabet
        for(Character c: sigma){
            retString += c + " ";
        }

        retString += "}\ndelta =\n";

        //Add the transition table 
        retString += "\t\t";
        for(Character c: sigma){
            retString += c + "\t";
        }
        retString += "\n";
        for(DFAState s: states){
            retString += "\t" + s.getName() + "\t";
            for(Character c: sigma){
                // Check if transition exists before getting its name to avoid null pointer exception.
                String transitionName = getToState(s, c) == null ? "" : getToState(s, c).getName();
                retString += transitionName + "\t";
            }
            retString += "\n";
        }

        //Add the initial state
        retString += "qo = " + startState.getName() + "\n";

        //Add final state
        retString += "F = { ";
        for(DFAState f: finalStates){
            retString += f.getName() + " ";
        }
        retString += "} \n";

        return retString;
    }
}
