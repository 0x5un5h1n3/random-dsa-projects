package dsa_day_04;

public class TailRecursive {
    
    public void TailRecursiveFunction(int y) {
        
        if (y > 0) {
            System.out.println(y);
            TailRecursiveFunction(y - 1);
        }
    }
    
    public static void main(String[] args) {
        TailRecursive tr = new TailRecursive();
        tr.TailRecursiveFunction(10);
    }
}
