package blind75;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKElements {

    public static void main(String[] args) {

        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        System.out.println(Arrays.toString(topK(nums, k)));
    }

    public static int[] topK(int[] nums, int k) {

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> queue
                = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        for (Map.Entry entry : frequencyMap.entrySet()) {
            queue.add(entry);
        }

        int[] output = new int[k];
        for (int i = 0; i < k; i++) {
            output[i] = queue.poll().getKey();
        }

        return output;

    }
}
