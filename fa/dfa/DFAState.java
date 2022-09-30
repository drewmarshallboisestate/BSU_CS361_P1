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

    public DFAState(String name){
        this.name = name;
        transitionMap = new LinkedHashMap<>();
    }

    public void insertTrans(char symb, DFAState toState){
        transitionMap.put(symb, toState);
    }

    public Map<Character, DFAState> getTrans() {
        return transitionMap;
    }
}
