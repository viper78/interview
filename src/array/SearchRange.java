package array;

import java.util.Arrays;

public class SearchRange {

    public static void main(String[] args) {
        int[] num = {1,3};
        int target = 1;

        Arrays.stream(searchRange(num, target)).forEach(s-> System.out.print(s + " "));

    }

    public static int[] searchRange(int[] nums, int target) {

        int[] arr = new int[2];
        Arrays.fill(arr, -1);

        searchRange(nums, target, 0, nums.length - 1, arr);

        return arr;
    }

    private static void searchRange(int[] nums, int target, int low, int high, int[] arr) {

        if (low > high) return;

        if (nums[low] == nums[high] && nums[low] == target) {
            arr[0] = low;
            arr[1] = high;
            return;
        }

        int mid = low + (high-low)/2;

        if (nums[mid] > target) {
            searchRange(nums, target, low, mid - 1, arr);
        } else if (nums[mid] < target) {
            searchRange(nums, target, mid + 1, high, arr);
        } else {
            arr[0] = mid;
            arr[1] = mid;

            int l = mid;
            while (l > 0 && nums[l] == nums[l-1]) {
                l--;
            }
            arr[0] = l;

            int r = mid;
            while (r < nums.length -1 && nums[r] == nums[r+1]) {
                r++;
            }
            arr[1] = r;
        }
    }
}
