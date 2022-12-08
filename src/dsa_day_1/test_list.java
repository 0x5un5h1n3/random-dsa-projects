
package dsa_day_2;

public class test_list {
    
    public static void main(String[] args) {
        Node rootNode = new Node();
        
        rootNode.val = 1000;
        rootNode.n = new Node();
        
        rootNode.n.val = 2000;
        rootNode.n.n = new Node();
        rootNode.n.n.val = 3000;
        
        System.out.println("val: "+ rootNode.val);
        System.out.println("n.val: "+ rootNode.n.val);
        System.out.println("n.n.val: "+ rootNode.n.n.val);
    }
}
