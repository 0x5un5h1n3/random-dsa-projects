package dsa_day_04;

public class HeadRecursive {
    
    public void HeadRecursiveFunction(int x) {
        
        if (x > 0) {
            HeadRecursiveFunction(x - 1);
            System.out.println(x);
        }
    }
    
    public static void main(String[] args) {
        HeadRecursive hr = new HeadRecursive();
        hr.HeadRecursiveFunction(10);
    }
}
