package dsa_day_3;

import java.util.Arrays;

public class A {

    public static void main(String[] args) {

        int[] x = new int[]{10, 20, 30};
        int[] y = new int[]{10, 20, 30};
        
        System.out.println(x);
        System.out.println(y);
        
        if(x == y){
            System.out.println("== True");
        }else{
            System.out.println("== False");
        }
        
        if (x.equals(y)){
            System.out.println("x.equals True");
        }else{
            System.out.println("x.equals False");
        }
        
        if(Arrays.equals(x,y)){
            System.out.println("Arrays.equals True");
        }else{
            System.out.println("Arrays.equals False");
        }
    }
}
