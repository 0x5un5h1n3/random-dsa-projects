package dsa_day_5;

public class BinarySearch {

    public int binary_search(int array[], int keyword) {
        int lower = 0;
        int higher = array.length - 1;

        while (lower <= higher) {
            int mid = lower + (higher - lower) / 2; //Middle position
            if (array[mid] == keyword) {
                return mid;
            }
            if (array[mid] < keyword) {
                lower = mid + 1;
            } else {
                higher = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int x[] = new int[]{23, 56, 90, 1, 3, 4, 5, 6, 7}; // unsorted array
        BubbleSort bs = new BubbleSort();
        bs.bubble_sort(x);
        int found = new BinarySearch().binary_search(x, 3);

        if (found == -1) {
            System.out.println("No Value");
        } else {
            System.out.println(found);
        }
    }
}
