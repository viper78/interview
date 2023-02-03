package blind75;

import java.util.Arrays;

public class TrappedRainWater {

    public static void main(String[] args) {
//        int arr[] = {3, 0, 0, 2, 0, 4};
        int arr[] = {1,8,6,2,5,4,8,3,7};
        int n = 9;


    }

    public int maxArea(int[] height) {

        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {

            if (height[left] < height[right]) {
                maxArea = Math.max(maxArea, height[left] * (right - left));
                left++;
            } else {
                maxArea = Math.max(maxArea, height[right] * (right - left));
                right--;
            }
        }
        return maxArea;
    }
}
