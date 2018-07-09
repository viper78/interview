package array;

import java.util.Arrays;

public class SortColors {

    public static void main(String[] args) {
        int[] colors = {1,0,2,1,0,1,2,0,0,1,2};

        int[] sorted = sort(colors);
        Arrays.stream(sorted).forEach(s-> System.out.print(s + " "));
    }

    private static int[] sort(int[] colors) {

        int low = 0;
        int mid = 0;
        int high = colors.length - 1;

        while (mid <= high) {

            if (colors[mid] == 0) {
                swap(colors, low, mid);
                mid++;
                low++;
            } else if (colors[mid] == 2) {
                swap(colors, mid, high);
                high--;
            } else {
                mid++;
            }
        }

        return colors;
    }

    private static void swap(int[] colors, int i, int j) {
        int temp = colors[i];
        colors[i] = colors[j];
        colors[j] = temp;
    }
}
