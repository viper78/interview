package blind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OverlappingIntervals {

    public static void main(String[] args) {

        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};

        System.out.println(eraseOverlapIntervals(intervals));
    }
    public static int eraseOverlapIntervals(int[][] intervals) {

        if (intervals == null || intervals.length == 0) return 0;
        if (intervals.length == 1) return 0;

        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        // {{1,2},{1,3},{2,3},{3,4}}
        List<int[]> merged = new ArrayList<>();
        int[] prev = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (prev[1] <= intervals[i][0]) {
                merged.add(prev);
                prev = intervals[i];
            } else {
                prev[1] = Math.min(prev[1], intervals[i][1]);
            }
        }
        merged.add(prev);

        merged.stream().map(Arrays::toString).forEach(System.out::println);
        return intervals.length - merged.size();
    }
}
