package fa.dfa;

import java.util.HashMap;
import java.util.LinkedHashMap;

import fa.State;

public class DFAState extends State{
    
    private LinkedHashMap<Character, DFAState> transitionMap;

    public DFAState(String name){
        this.name = name;
        transitionMap = new LinkedHashMap<>();
    }

    public void transition(char symb, DFAState toState){
        transitionMap.put(symb, toState);
    }
}
