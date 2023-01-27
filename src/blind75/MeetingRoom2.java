package blind75;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoom2 {

    public static void main(String[] args) {
//         int[][] intervals = {{0, 30}, {15,20}, {5,10}};

        int[][] intervals = {{7, 10}, {2,4}, {3, 11}};

        System.out.println(minMeetingRooms(intervals));
    }

    public static int minMeetingRooms(int[][] slots) {

        if (slots == null || slots.length == 0) return 0;
        if (slots.length == 1) return 1;

        Arrays.sort(slots, (a,b) -> a[1] - b[1]);
        // [5,10], [15,20], [0,30]
        // [2,4],[3,11],[7,10]
        int count = 1;
        int[] prev = slots[0];
        for (int i = 1; i < slots.length; i++) {
            if (prev[1] > slots[i][0]) {
                count++;
            }
            prev = slots[i];
        }
        return count;
    }
}
