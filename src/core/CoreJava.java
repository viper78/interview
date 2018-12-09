package core;

import java.util.ArrayList;
import java.util.List;

public class CoreJava {

    public static void main(String[] args) {

        int[] nums1 = {4,1,2,1,2};
        int[] nums2 = {2,2};
        
        int result = singleNumber(nums1);

        CoreJava cj = new CoreJava();
        cj.execute();
        System.out.println(result);
    }

    public void execute() {
        Test cj = new Test();
            Object obj = cj.clone();
            System.out.println(obj instanceof Test);

    }

    private static int singleNumber (int[] nums) {


        for (int i = 0; i < nums.length; i++) {

            if (nums[Math.abs(nums[i])] > 0) {
                return nums[i];
            }

            nums[Math.abs(nums[i])] = - nums[Math.abs(nums[i])];
        }
        return -1;
    }

    class Test implements Cloneable {

        protected Test clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return new Test();
        }
    }
}
