package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class ShortestRange {

    public static void main(String[] args) {

        List<Integer> list1 = Arrays.asList(4,10,15,24,26);
        List<Integer> list2 = Arrays.asList(0,9,12,20);
        List<Integer> list3 = Arrays.asList(5,18,22,30);

        List<List<Integer>> list = new ArrayList<>();
        list.add(list1);
        list.add(list2);
        list.add(list3);

        shortest(list);
    }

    private static Object[] shortest(List<List<Integer>> list) {

        PriorityQueue<Node> queue = new PriorityQueue<Node>();

        for (int i = 0; i < list.size(); i++) {
            Node n = new Node();
            n.value = list.get(i).get(0);
            n.pos = i;
            n.index = 0;
            queue.add(n);
        }
        Object[] rangeElements = queue.toArray();
        Node high = (Node)rangeElements[rangeElements.length - 1];
        Node low = (Node)rangeElements[0];
        int minRange = high.value - low.value;

        while (!queue.isEmpty()) {
            Node n = queue.poll();

            if (n.index + 1 < list.get(n.pos).size()) {
                n.value = list.get(n.pos).get(n.index + 1);
                n.index = n.index + 1;
                queue.add(n);

                rangeElements = queue.toArray();
                Arrays.sort(rangeElements);
                high = (Node) rangeElements[rangeElements.length - 1];
                low = (Node) rangeElements[0];
                int currRange = high.value - low.value;
                if (currRange < minRange) {
                    minRange = currRange;
                }
            } else {
                break;
            }

        }
        return rangeElements;
    }

    static class Node implements Comparable<Node>{
        int value;
        int pos;
        int index;

        public int compareTo(Node n1) {
            if (this.value > n1.value) return 1;
            else if (this.value < n1.value) return -1;
            else return 0;
        }
    }
}
