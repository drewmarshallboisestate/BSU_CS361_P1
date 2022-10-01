package fa.dfa;

import java.util.*;
import fa.State;

/**
 * Models a DFA state containing its name and transitions.
 * 
 * @author Drew Marshall
 */
public class DFAState extends State {
    
    private LinkedHashMap<Character, DFAState> transitionMap;

    /**
	 * Creates a DFAState that will create HashMap
     * to store the states transitions 
	 * @param name is the label of the state 
	 */
    public DFAState(String name){
        this.name = name;
        transitionMap = new LinkedHashMap<>();
    }

    /**
	 * Creates a transition for the DFAState to store
     * as it processes what each transition is for 
     * each state
	 * @param symb is the transition character
     * @param toState is the state the transition will extend to
	 */
    public void insertTrans(char symb, DFAState toState){
        transitionMap.put(symb, toState);
    }

    /**
	 * Will output a transition map for the state 
	 * @returns the transition HashMap for the DFAState
	 */
    public Map<Character, DFAState> getTrans() {
        return transitionMap;
    }
}
