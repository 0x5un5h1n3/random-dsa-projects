package dsa_day_07;


public class BinaryTree {
 
    //Root of Binary Tree
    Node root;
    
    public BinaryTree(int key){
        root = new Node(key);
    }
    
    public BinaryTree(){
        root = null;
    }
    
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        //Create Node
        tree.root = new Node(0);
        
//             0
//            / \
//         null  null

        tree.root.left = new Node(1);
        tree.root.right = new Node(2);
      
//             0
//            / \
//           1   2
//          / \  / \
//      nullnullnullnull


        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(6);
        
//             0
//            / \
//           1   2
//          / \  / \
//         3   4 5  6

    }
}
