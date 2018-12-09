package array;

public class MaxIndexDiff {

    // Find Max j-i such that arr[j]> arr[i]
    public static void main(String[] args) {
        //O(n)
        int[] arr = {9, 2, 3, 4,5, 6, 7, 8 , 18, 0};

        int maxDiff = findMaxDiff(arr);

        System.out.println(maxDiff);
    }

    private static int findMaxDiff(int[] arr) {

        int max = Integer.MIN_VALUE;

        int[] leftMin = new int[arr.length];
        int[] rightMax = new int[arr.length];

        leftMin[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            leftMin[i] = Math.min(arr[i], leftMin[i-1]);
        }

        rightMax[arr.length - 1] = arr[arr.length - 1];
        for (int j = arr.length -2; j >= 0; j--) {
            rightMax[j] = Math.max(arr[j], rightMax[j+1]);
        }

        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, rightMax[i] - leftMin[i]);
        }
        int i = 0;
        int j = 0;

//        while (i < arr.length - 1 && j < arr.length - 1) {
//
//            if (leftMin[i] < rightMax[j]) {
//                max = Math.max(max, rightMax[j] - leftMin[i]);
//                i++;
//            } else {
//                j++;
//            }
//        }

        return max;
    }
}
