package edu.tum.cs.i1.statechart;

import java.util.HashSet;
import java.util.Set;

public class StateChartDiagram {
    private String name;
    private StartNode startState;
    private FinalNode finalState;

    private Set<Transition> transitions;

    public StateChartDiagram(String name) {
        this.name = name;
        this.transitions = new HashSet<>();
    }

    public void setStartState(StartNode s) {
        this.startState = s;
    }

    public void setFinalState(FinalNode s) {
        this.finalState = s;
    }

    public void addTransition(Transition t) {
        transitions.add(t);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append("edu.tum.cs.i1.statechart.StateChartDiagram \"").append(this.name).append("\"\n");
        output.append("Starting edu.tum.cs.i1.statechart.Node points to ");
        transitions.stream()
                .filter(transition -> transition.getFrom().equals(this.startState))
                .forEach(transition -> output.append((transition.getTo()).getName()));

        output.append("\n");
        for (Transition t : transitions) {
            output.append("From ")
                    .append(t.getFrom().getName())
                    .append(" you reach ")
                    .append(t.getTo().getName())
                    .append(" via ")
                    .append(t.getDescription())
                    .append("\n");
        }
        output.append("The final state is ")
                .append(this.finalState.getName());

        return output.toString();
    }
}
