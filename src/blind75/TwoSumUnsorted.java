package blind75;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class TwoSumUnsorted {

    public static void main(String[] args) {
        int[] numbers = {-2,-3,5,4,6};
        int target = 3;

        System.out.println(Arrays.toString(twoSum(numbers, target)));
    }

    public static int[] twoSum(int[] arr, int target) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            int compliment = target - arr[i];
            if (set.contains(compliment)) {
                return new int[] {arr[i], compliment};
            }
            set.add(arr[i]);
        }
        return new int[] {0,0};
    }
}
