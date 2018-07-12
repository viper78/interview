package binarysearch;

public class SquareRoot {

    public static void main(String[] args) {

        int num = 16;

        int root = findRoot(num);
        System.out.println(root);
    }

    private static int findRoot(int num) {

        if (num == 0 || num == 1)
            return num;

        int low = 1;
        int high = num;

        while (low <= high) {

            int mid = low + (high - low)/2;

            int temp = mid*mid;

            if (temp == num) {
                return mid;
            } else if (temp > num) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        return -1;
    }
}
