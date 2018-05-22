public class Transition {
    private Node from;
    private Node to;

    private String guardPredicate;
    private String action;
    private String userAction;

    public Transition (Node from, Node to, String guardPredicate, String userAction, String action) {
        if (guardPredicate != null && userAction != null) {
            throw new RuntimeException("A transition is EITHER triggered by user action or by a guardPredicate");
        }
        this.from = from;
        this.to = to;
        this.guardPredicate = guardPredicate;
        this.action = action;
        this.userAction = userAction;
    }

    public Node getFrom() {
        return from;
    }

    public Node getTo() {
        return to;
    }

    public String getDescription() {
        if (guardPredicate == null && userAction == null) {
            if (action == null) {
                return "a triggerless transaction";
            }
            return "/" + action;
        }
        return (guardPredicate != null ? "[" + guardPredicate + "]" : "\"" + userAction + "\"") + "/" + action;
    }
}
