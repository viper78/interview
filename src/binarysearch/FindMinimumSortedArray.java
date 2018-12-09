package binarysearch;

public class FindMinimumSortedArray {

    public static void main(String[] args) {
        int[] num = {3,4,2,1,2};
        System.out.println(findMin2(num));
        System.out.println("Index :" + findPeakElement(num));
    }

    public static int findMin2(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high)/2;
            if ((mid == 0 || nums[mid] < nums[mid - 1]) &&
                    (mid == nums.length - 1 || nums[mid] < nums[mid + 1])) {
                return nums[mid];
            } else if (nums[mid] < nums[high]){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static int findPeakElement(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (mid == 0 && nums[mid] > nums[mid + 1] ||
                    mid == nums.length - 1 && nums[mid] > nums[mid - 1] ||
                    mid > 0 && mid < nums.length - 1 && nums[mid] > nums[mid - 1] &&
                            nums[mid] > nums[mid + 1]) {
                return mid;
            }

            if (nums[mid] > nums[mid + 1]) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

}
