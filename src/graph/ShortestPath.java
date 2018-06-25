package graph;

import java.util.*;

public class ShortestPath {

    public static void main(String[] args) {

        Node[] graph = new Node[5];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new Node(i+1);
        }

        graph[0].addChild(graph[1]);
        graph[0].addChild(graph[2]);
        graph[1].addChild(graph[4]);
        graph[3].addChild(graph[0]);
        graph[3].addChild(graph[2]);
        graph[4].addChild(graph[3]);

        List<Node> list = findShortestPath(graph[0], graph[3]);
        list.stream().map(e -> e.data).forEach(System.out::println);
    }

    private static List<Node> findShortestPath(Node from, Node to) {

        if (from == null || to == null) return null;

        if (from == to) return null;

        Queue<Node> queue = new LinkedList<>();
        Map<Node, Node> parentMap = new HashMap<>();

        queue.add(from);
        parentMap.put(from, null);

        while (!queue.isEmpty()) {
            Node n = queue.poll();

            if (n == to) break;
            if (n.children == null) continue;

            for (Node child: n.children) {
                queue.add(child);
                parentMap.put(child, n);
            }
        }

        if (parentMap.get(to) == null) return null;

        List<Node> list = new ArrayList<>();
        Node n = to;

        while (n != null) {
            list.add(n);
            n = parentMap.get(n);
        }

        return list;
    }

    static class Node {
        int data;
        List<Node> children;

        Node(int data) {
            this.data = data;

        }

        void addChild(Node n) {
            if (children == null) children = new ArrayList<>();
            children.add(n);
        }

        public boolean equals(Object o) {
            if (o == null) return false;
            if (!(o instanceof Node)) return false;
            Node n = (Node) o;

            return (n.data == data) ? true : false;
        }

        public int hashCode() {
            int result = 17;

            result += 31 * data;

            return result;
        }
    }

}
