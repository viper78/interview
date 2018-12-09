package array;

import java.util.HashMap;
import java.util.Map;

public class NextGreaterElement {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }

        for (int i = 0; i < nums1.length; i++) {
            int index = map.get(nums1[i]);
            if (index + 1 < nums2.length && nums2[index + 1] > nums1[i]) {
                nums1[i] = nums2[index + 1];
                continue;
            }
            nums1[i] = -1;
        }
        return nums1;
    }

    public int[] findArray(int[] nums1, int[] nums2) {

        for (int i = 0; i < nums1.length; i++) {
            if (i + 1 < nums2.length && nums2[i+1] > nums1[i]) {
                nums1[i] = nums2[i+1];
            } else {
                nums1[i] = -1;
            }
        }
        return nums1;
    }

    public static void main(String[] args) {
        NextGreaterElement nge = new NextGreaterElement();
        int[] nums = nge.nextGreaterElement(new int[] {4,1,2}, new int[] { 1,3,4,2 });
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

        int[] nums1 = nge.findArray(new int[] {4,1,2}, new int[] { 1,3,4,2 });
        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }
    }
}
