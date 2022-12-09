package dsa_day_5;

public class BubbleSort {

    public void bubble_sort(int[] array) {
        int n = array.length;
        System.out.println("Array Length : " + n);

        for (int i = 0; i < (n - 1); i++) { // array index count
//            System.out.println(i);

            for (int j = 0; j < n - i - 1; j++) { //swap

                if (array[j] > array[j + 1]) {
                    
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] data = new int[]{3, 5, 45, 6, 454, 121, 550, 3333};
        BubbleSort bs = new BubbleSort();
        bs.bubble_sort(data);

        for (int i = 0; i < data.length; i++) {
            int x = data[i];
            System.out.println(x);
        }
    }
}
