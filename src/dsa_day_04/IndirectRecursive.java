package dsa_day_04;

public class IndirectRecursive {
    
    public void function1(int x) {
        if (x > 0) {
            System.out.println("Function 1 :" + x);
            function2(x - 1);
        }
    }
    
    public void function2(int y) {
        System.out.println("Function 2 " + y);
        function3(y);
    }
    
    public void function3(int z) {
        function1(z);
        System.out.println("Function3 " + z);
    }

    public static void main(String[] args) {
        new IndirectRecursive().function1(10);
    }
}
