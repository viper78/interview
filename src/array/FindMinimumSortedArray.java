package array;

public class FindMinimumSortedArray {

    public static void main(String[] args) {
        int[] num = {3,4,5,1,2};
        System.out.println(findMin(num));
    }

    public static int findMin(int[] num) {

        return findMin(num, 0, num.length);
    }

    private static int findMin(int[] num, int low, int high) {

        if (low == high) return num[low];

        int mid = low + (high-low)/2;

        if (num[low] < num[mid]) return num[low];

        if (num[mid] > num[low]) {
            return findMin(num, mid + 1, high);
        } else {
            return findMin(num, low, mid - 1);
        }
    }
}
