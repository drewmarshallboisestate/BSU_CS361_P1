package fa.dfa;

import java.util.LinkedHashSet;
import java.util.Set;

import fa.State;

public class DFA implements DFAInterface{

    //Need to instantiate the 5-tuple with variables to hold values
    private LinkedHashSet<DFAState> states; //states = Q = all states
    private DFAState startState; //startState = q0 = starting state
    private LinkedHashSet<DFAState> finalStates; // finalStates = F = final states (if any)
    private LinkedHashSet<Character> sigma; //sigma = alphabet 

    @Override
    public void addStartState(String name) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void addState(String name) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void addFinalState(String name) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void addTransition(String fromState, char onSymb, String toState) {
        // TODO Auto-generated method stub
        // Need to implement a Map interface most likely a hashMap
        
    }

    @Override
    public Set<? extends State> getStates() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Set<? extends State> getFinalStates() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public State getStartState() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Set<Character> getABC() {
        // TODO Auto-generated method stub
        return null;
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
    
}
