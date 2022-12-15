package dsa_day_7;


public class Node {
    
    int key;
    Node right, left;
    
    public Node(int item){
        this.key = item;
        left = right = null;
    }
}
