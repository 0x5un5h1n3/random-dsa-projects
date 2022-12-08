package dsa_day_3;

import java.util.Arrays;

public class C2 {

    public static void main(String[] args) {

        int[] k = new int[]{1, 2, 3};
        int j[] = Arrays.copyOf(k, k.length);

        System.out.println(k);
        System.out.println(j);

        for (int i = 0; i < k.length; i++) {
            int m = k[i];
            System.out.println("k : " + m);
        }
        for (int i = 0; i < j.length; i++) {
            int n = j[i];
            System.out.println("j : " + n);
        }
    }
}
