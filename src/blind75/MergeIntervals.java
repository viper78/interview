package blind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MergeIntervals {

    public static void main(String[] args) {

        int[][] intervals = {{1,3},
                            {2,6},
                            {8,5},
                            {15,18}};

//        Arrays.stream(intervals).map(Arrays::toString).forEach(System.out::println);
//        System.out.println("---------");
//        System.out.println(Arrays.toString(intervals[0]));
//        int[] temp = intervals[0];
//        System.out.println("Temp 0:"+ Arrays.toString(new int[]{temp[0]}));
//        System.out.println("Temp 1:"+ Arrays.toString(new int[]{temp[1]}));
//        System.out.println(Arrays.toString(intervals[1]));
//        System.out.println("---------");
//        Arrays.sort(intervals, (a, b) -> b[0] - a[0]);
//        Arrays.stream(intervals).map(Arrays::toString).forEach(System.out::println);

        Arrays.stream(merge(intervals)).map(Arrays::toString).forEach(System.out::println);
    }
    public static int[][] merge(int[][] intervals) {
        List<int[]> output = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] prev = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (prev[1] < intervals[i][0]) {
                output.add(prev);
                prev = intervals[i];
            } else {
                prev[1] = Math.max(prev[1], intervals[i][1]);
            }
        }
        output.add(prev);

        return output.toArray(new int[output.size()][2]);
    }
}
