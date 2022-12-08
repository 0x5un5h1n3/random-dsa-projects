package dsa_day_3;

public class C {

    public static void main(String[] args) {

        int[] x = new int[]{1, 2, 3};
        int[] y = new int[x.length];

        for (int i = 0; i < x.length; i++) {
            y[i] = x[i];
        }

        y[2] = 100;

        System.out.println(x);
        System.out.println(y);

        for (int i = 0; i < x.length; i++) {
            int j = x[i];
            System.out.println("x :" + j);
        }

        for (int i = 0; i < y.length; i++) {
            int m = y[i];
            System.out.println("y : " + m);
        }
    }
}
