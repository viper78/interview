package array;

import java.util.Arrays;
import java.util.List;

public class RemoveElement {

    public static void main(String[] args) {
        RemoveElement re = new RemoveElement();

        List<Integer> list = Arrays.asList(0,0,1,1,1,2,2,3,3,4);

        System.out.println(re.removeElement(list, 1));

        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(re.removeElement(nums, 1));

        for (int i : nums) {
            System.out.print(i + " ");
        }

        System.out.println(list);
    }

    public int removeElement(List<Integer> list, int b) {
        int k = 0;
        for(int i = 0;i < list.size();i++) {
            if(list.get(i) != b) {
                list.set(k, list.get(i));
                k++;
            }
        }
        return k;
    }

    public int removeElement(int[] nums, int val) {
        if( nums == null) { return 0; }
        int nonTarget = 0;
        for( int i = 0; i < nums.length; i++) {
            if( nums[i] != val) {
                nums[nonTarget] = nums[i];
                nonTarget++;
            }
        }
        return nonTarget;
    }
}
