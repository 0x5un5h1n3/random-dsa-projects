package dsa_day_8;

public class Node {

    String data;
    Node Right_node, Left_node;

    public Node(String item) {
        data = item;
        Right_node = Left_node = null;
    }
}
