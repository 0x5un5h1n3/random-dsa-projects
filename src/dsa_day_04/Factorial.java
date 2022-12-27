package dsa_day_04;

public class Factorial {
    
    public int fact(int c) {
        if (c > 0) {
            return c * fact(c - 1);
        }
        return 1;
    }
    
    public static void main(String[] args) {
        Factorial f = new Factorial();
        System.out.println(f.fact(4));
    }
}
