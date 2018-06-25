package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsList {

    public static void main( String[] args ) {
        SubsetsList list = new SubsetsList();
        int[] num = new int[]{1, 2, 3, 4};
        List<List<Integer>> result = list.subsets( num );

        result.stream().forEach( System.out::println );

    }

    public List<List<Integer>> subsets( int[] nums ) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort( nums );
        backtrack( list, new ArrayList<>(), nums, 0 );
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> temp, int[] nums, int index ) {
        list.add( new ArrayList<>( temp ) );
        List<Integer> visited = new ArrayList();
        for (int i = index; i < nums.length; i++) {
            if (!visited.contains(nums[i])) {
                temp.add(nums[i]);
                backtrack(list, temp, nums, i + 1);
                temp.remove(temp.size() - 1);
                visited.add(nums[i]);
            }
        }
    }
}

