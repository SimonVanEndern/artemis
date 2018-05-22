import org.junit.Test;

public class StateNodeChartDiagramTest {

    @Test
    public void testFullStateChartDiagram() {
        StateChartDiagram diagram = new StateChartDiagram("Dynamic behavior of user car");

        StartNode startNode = new StartNode();
        diagram.setStartState(startNode);

        FinalNode finalNode = new FinalNode();
        diagram.setFinalState(finalNode);

        StateNode userCarMoving = new StateNode("User Car Moving");
        userCarMoving.addDoAction("Change Speed");
        userCarMoving.addDoAction("Steer");
        StateNode collisionTest = new StateNode("Collision Test");
        collisionTest.addDoAction("Evaluate()");

        StateNode userCarCrunched = new StateNode("User Car crunched");
        StateNode userCarStopped = new StateNode("User Car stopped");

        DecisionNode evaluate = new DecisionNode("evaluate");

        diagram.addTransition(new Transition(startNode, userCarMoving, null, null, null));
        diagram.addTransition(new Transition(userCarMoving, collisionTest, "overlap occurs", null, "detectCollision()"));
        diagram.addTransition(new Transition(userCarMoving, finalNode, null, "user clicks \"Stop Game\" in the Menu", "stopGame()"));
        diagram.addTransition(new Transition(collisionTest, evaluate, null, null, null));
        diagram.addTransition(new Transition(evaluate, userCarCrunched, "evaluate==false", null, "setCrunched()"));
        diagram.addTransition(new Transition(evaluate, userCarStopped, "evaluate==true", null, "winCollision()"));
        diagram.addTransition(new Transition(userCarCrunched, userCarStopped, null, null, "setSpeed(0)"));
        diagram.addTransition(new Transition(userCarStopped, finalNode, null, null, "stopGame()"));


        System.out.println(diagram);
    }
}
