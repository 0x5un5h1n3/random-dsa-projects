package dsa_day_08;

import java.util.Arrays;

public class DynamicArrays {

    int[] data;
    int count;
    int size;

    public DynamicArrays() {
        count = 0;
        size = 1;
        data = new int[size];
    }

    public DynamicArrays(int preSize) {
        count = 0;
        size = preSize;
        data = new int[size];
    }

    public void growSize() { //  dynamic behaviour
        if (count == size) {
            data = Arrays.copyOf(data, size * 3);  //data = Arrays.copyOf(data, size + 100);
            size = size * 3;
        }
    }

    public void setCapacity(int cap) {

        if (size < cap) {
            data = Arrays.copyOf(data, cap);
        }
    }

    public void add(int val) {
        growSize();
        data[count++] = val;
    }

    public static void main(String[] args) {
        DynamicArrays a = new DynamicArrays();
        a.add(10);
        a.add(20);
        a.add(34);
        a.add(555);
        a.add(200);
        a.add(15);

        for (int i = 0; i < a.count; i++) {
            System.out.println(a.data[i]);
        }
    }
}
