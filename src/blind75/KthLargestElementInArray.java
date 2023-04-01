package blind75;

import java.util.PriorityQueue;
public class KthLargestElementInArray {

    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int n: nums) {
            queue.add(n);
            if (queue.size() > k) {
                queue.remove();
            }
        }
        return queue.remove();
    }

}
