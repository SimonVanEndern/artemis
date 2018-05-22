package edu.tum.cs.i1.statechart;

import java.util.HashSet;
import java.util.Set;

public class StateNode extends NamedNode {

    private static String shape = "Box with rounded Corners";

    private Set<String> entryActions;
    private Set<String> doActions;
    private Set<String> exitActions;

    public StateNode(String name) {
        super(name);
        this.entryActions = new HashSet<>();
        this.doActions = new HashSet<>();
        this.exitActions = new HashSet<>();
    }

    public void addEntryAction(String entryAction) {
        this.entryActions.add(entryAction);
    }

    public void addDoAction(String doAction) {
        this.doActions.add(doAction);
    }

    public void addExitAction(String exitAction) {
        this.exitActions.add(exitAction);
    }

}
