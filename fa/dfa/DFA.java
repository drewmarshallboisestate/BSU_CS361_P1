package fa.dfa;

import java.util.LinkedHashSet;
import java.util.Set;

import fa.State;

public class DFA implements DFAInterface{

    //Need to instantiate the 5-tuple with variables to hold values
    private LinkedHashSet<DFAState> states; //states = Q = all states
    private LinkedHashSet<DFAState> finalStates; // finalStates = F = final states (if any)
    private LinkedHashSet<Character> sigma; //sigma = alphabet 
    private DFAState startState; //startState = q0 = starting state

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
            if(stateName.equals(name)){ //Start state is already in states so we just have to update it
                startState = s;
            }       
        }

        if(startState == null) {
            startState = new DFAState(name);
            states.add(startState);
        }
    }

    @Override
    public void addState(String name) {
        DFAState state = new DFAState(name);
        states.add(state);
        
    }

    public DFAState getState(String state){
        DFAState retState = null;
        for(DFAState s: states){
            String stateName = s.getName();
            if(stateName.equals(state)){
                retState = s;
            }
        }
        return retState;
    }

    @Override
    public void addFinalState(String name) {
        DFAState fState = new DFAState(name);
        finalStates.add(fState);
        states.add(fState);
        
    }

    @Override
    public void addTransition(String fromState, char onSymb, String toState) {
        DFAState stateFrom = new DFAState(fromState);
        DFAState stateTo = new DFAState(toState);
        stateFrom.insertTrans(onSymb, stateTo);

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

    @Override
    public Set<? extends State> getStates() {
        return states;
    }

    @Override
    public Set<? extends State> getFinalStates() {
        return finalStates;
    }

    @Override
    public State getStartState() {
        return startState;
    }

    @Override
    public Set<Character> getABC() {
        return sigma;
    }

    @Override
    public boolean accepts(String s) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public State getToState(DFAState from, char onSymb) {
        // TODO Auto-generated method stub
        return null;
    }
    
    public String toString() {
        // TODO Modify the toString method to match required output
        return null;
    }
}
