package blind75;

import java.util.ArrayList;
import java.util.List;

public class EarlistMeetingTime {

    public static void main(String[] args) {
        int[][] slotA = {{10, 50},{60, 120}, {140, 210}};
        int[][] slotB = {{0, 15},{60, 70}};
        int duration = 1;

        List<int[]> overlap = earlistmeetingSlot(slotA, slotB, duration);
        System.out.println(overlap);
    }

    static List<int[]> earlistmeetingSlot(int[][] slotA, int[][] slotB, int duration) {
        List<int[]> output = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < slotA.length && j < slotB.length) {

            int[] curr_slotA = slotA[i];
            int[] curr_slotB = slotB[j];

            if (curr_slotA[1] < curr_slotB[0]) {
                i++;
            } else if (curr_slotB[1] < curr_slotA[0]) {
                j++;
            } else {
                if (duration >= Math.max(curr_slotA[0], curr_slotB[0]) - Math.min(curr_slotA[1], curr_slotB[1])) {
                    int[] overlap = new int[2];
                    overlap[0] = Math.max(curr_slotA[0], curr_slotB[0]);
                    overlap[1] = overlap[0] + duration;
                    output.add(overlap);

                    return output;
                }
                i++;
                j++;
            }

        }


        return output;
    }
}
