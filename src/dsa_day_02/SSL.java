
package dsa_day_2;

public class SSL {
    Node head = null; // root Node
    Node tail = null; // last Node
    
    public void Add(int val){
        Node nn = new Node(val);
        
        if(head == null){
            head = nn;
            tail = nn;
        }else{
            tail.n = nn;
            tail = nn;
        }
    }
    
    public void View(){
        Node c = head;
        while(c != null){
            System.out.println(c.data);
            c = c.n;
        }
    }
    
    public Node Get(int position){
        Node c = head;
        for(int y = 1; y < position; y++){
            c = c.n;
        }
        return c;
    }
    
    
    public void Set(int position, int Val){
        Node newVal = new Node(Val);
        Node x = Get(position);
        x.data= newVal.data;
    }
    
    public void Remove(int position){
        Node removeSelectedObj = Get(position);
        Node next = removeSelectedObj.n;
        
        removeSelectedObj.data = next.data;
        removeSelectedObj.n= next.n;
        
    }
    
    public static void main(String[] args) {
        SSL list = new SSL();
        list.Add(1000);
        list.Add(3500);
        list.Add(2);
        list.View();
        
        System.out.println("------------");
        System.out.println(list.Get(1).data);
        System.out.println(list.Get(3).data);
        
        
        System.out.println("------------");
        list.Set(2, 500);
        list.View();
        
        System.out.println("------------");
        list.Remove(2);
    }
}
