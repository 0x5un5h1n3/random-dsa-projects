package dsa_day_8;

public class BinaryTree {

    Node root;

    public BinaryTree(String key) {
        root = new Node(key);
    }

    public BinaryTree() {
        root = null;
    }

    void preOrder(Node n) {
        if (n == null) {
            return;
        }
        System.out.print(n.data + " ");
        preOrder((n.Left_node));
        preOrder((n.Right_node));
    }

    void postOrder(Node n) {
        if (n == null) {
            return;
        }
        postOrder((n.Left_node));
        postOrder((n.Right_node));
        System.out.print(n.data + " ");
    }

    void inOrder(Node n) {
        if (n == null) {
            return;
        }
        inOrder((n.Left_node));
        System.out.print(n.data + " ");
        inOrder((n.Right_node));
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        //Create root
        tree.root = new Node("A");

        tree.root.Left_node = new Node("B");
        tree.root.Right_node = new Node("C");

        tree.root.Left_node.Left_node = new Node("D");
        tree.root.Left_node.Right_node = new Node("E");

        tree.root.Right_node.Left_node = new Node("F");
        tree.root.Right_node.Right_node = new Node("G");

        tree.root.Left_node.Left_node.Right_node = new Node("H");
        tree.root.Right_node.Left_node.Left_node = new Node("I");

        System.out.println("PRE ORDER");
        tree.preOrder(tree.root);

        System.out.println("\n\n");
        System.out.println("POST ORDER");
        tree.postOrder(tree.root);

        System.out.println("\n\n");
        System.out.println("IN ORDER");
        tree.inOrder(tree.root);

    }
}
