package heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKLists {

    public static void main(String[] args) {

        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(new Integer[]{2,4,6,8}));
        list.add(Arrays.asList(new Integer[]{1,3,5,7}));
        list.add(Arrays.asList(new Integer[]{9,10,11}));

        MergeKLists ml = new MergeKLists();
        ml.mergeList(list);
    }

    private void mergeList(List<List<Integer>> list) {

        List<Integer> mergedList = new ArrayList<>();
        PriorityQueue<Node> queue = new PriorityQueue();

        for (int i = 0; i < list.size(); i++) {
            Node n = new Node();
            n.index = 0;
            n.value = list.get(i).get(0);
            n.pos = i;

            queue.add(n);
        }

        while (!queue.isEmpty()) {
            Node n = queue.poll();
            mergedList.add(n.value);
            if (n.index + 1< list.get(n.pos).size()) {
                n.value = list.get(n.pos).get(n.index + 1);
                n.index = n.index + 1;
                queue.add(n);
            }
        }

        System.out.println(mergedList);

    }


    class Node implements Comparable<Node>{
        int pos;
        int value;
        int index;

        @Override
        public int compareTo(Node n1) {
            if (this.value > n1.value) return 1;
            else if (this.value < n1.value) return -1;
            else return 0;
        }
    }
}
