package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartitionKSubsets {

    public static void main(String[] args) {

        PartitionKSubsets ps = new PartitionKSubsets();
        int[] nums = {4,3,2,3,5,2,1};
        int k = 4;

        System.out.println(ps.canPartitionKSubsets(nums, k));
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if(k <= 0 || sum%k != 0)
            return false;
        List<Integer> visited = new ArrayList();
        int target = sum/k;
        return canPartition(nums, visited, 0, k, 0, 0, target);
    }

    public boolean canPartition(int[] nums, List<Integer> visited, int start_index, int k, int cur_sum, int cur_num, int target){
        if(k==1)
            return true;

        if(cur_sum == target && cur_num>0)
            return canPartition(nums, visited, 0, k-1, 0, 0, target);

        for(int i = start_index; i<nums.length; i++){
            if(!visited.contains(nums[i])){
                visited.add(nums[i]);
                if(canPartition(nums, visited, i+1, k, cur_sum + nums[i], cur_num++, target))
                    return true;
                visited.remove(visited.size() - 1);
            }
        }
        return false;
    }

}
