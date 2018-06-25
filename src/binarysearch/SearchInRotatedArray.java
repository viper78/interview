package binarysearch;

public class SearchInRotatedArray {
    public static void main(String[] args) {

        int[] num = {3,2,1,5,4};

        System.out.println(search(num, 2));
    }

    public static int search(int[] num, int target) {

        int low = 0;
        int high = num.length - 1;

        while (low <= high) {
            int mid = low + (high-low)/2;

            if (num[mid] == target) {
                return mid;
            }

            if (num[low] <= num[mid]) {
                if (num[low] <= target && target < num[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (num[low] >= target && target > num[mid]) {
                    high = mid -1;
                } else {
                    low = mid + 1;
                }
            }

        }

        return -1;
    }
}
