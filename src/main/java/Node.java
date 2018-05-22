public abstract class Node {
    private static String shape = "Some shape";

    private static int id_counter = 0;

    private int id;

    public Node () {
        this.id = id_counter++;
    }

    public abstract String getName();
}
