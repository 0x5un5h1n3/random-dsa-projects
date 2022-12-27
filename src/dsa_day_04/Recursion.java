package dsa_day_4;

public class Recursion {
    
    public void recursionMethod(int x) {
        
        System.out.println(x);
        if (x > 0) { //Base
            recursionMethod(x - 1);
        }
    }
    
    public static void main(String[] args) {
        Recursion s = new Recursion();
        s.recursionMethod(10);
    }
}
