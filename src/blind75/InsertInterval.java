package blind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{6,9}};
        int[] newInterval = {2,5};

        Arrays.stream(insert(intervals, newInterval)).map(Arrays::toString).forEach(System.out::println);
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> output = new ArrayList<>();

        for (int[] current: intervals) {

            if (current[1] < newInterval[0]) {
                output.add(current);
            } else if (newInterval[1] < current[0]) {
                output.add(newInterval);
                newInterval = current;
            } else {
                newInterval[0] = Math.min(current[0], newInterval[0]);
                newInterval[1] = Math.max(current[1], newInterval[1]);
            }
        }
        output.add(newInterval);

        return output.toArray(new int[output.size()][]);
    }
}
