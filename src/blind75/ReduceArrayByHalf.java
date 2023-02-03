package blind75;

import java.util.*;

public class ReduceArrayByHalf {

    public int minSetSize(int[] arr) {
        // Input: arr = [3,3,3,3,5,5,5,2,2,7]
        Arrays.sort(arr);
        int N = arr.length;
        int half = N/2;

        Map<Integer, Integer> freqMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a, b) -> (b.getValue()).compareTo(a.getValue()));

        for (int i = 0; i < arr.length; i++) {
            freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0) + 1);
        }

        queue.addAll(freqMap.entrySet());

        int counter = 0;
        while (!queue.isEmpty()) {

            Map.Entry<Integer, Integer> entry = queue.remove();
            counter += (Integer)entry.getValue();
            if (counter > half) {
                counter -= entry.getValue();
            } else {
                result.add(entry.getKey());
            }
        }

        return result.size();
    }
}
