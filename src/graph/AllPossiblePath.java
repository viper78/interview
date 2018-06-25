package graph;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllPossiblePath {
    public static void main (String[] args) {

        AllPossiblePath mc = new AllPossiblePath();

        List<List<Integer>> paths = mc.allPaths(new Integer(0), new Integer(3));

        for (int i = 0; i < paths.size(); i++) {
            paths.get(i).stream().forEach(s-> System.out.print(s + " "));
            System.out.println();
        }
    }

    public List<List<Integer>> allPaths(Integer from, Integer to) {
        List<List<Integer>> paths = new ArrayList();
        Map<Integer, List<Integer>> map = populate();
        List<Integer> tempList = new ArrayList<>();
        tempList.add(from);

        allPaths(from, to, map, paths, tempList, new ArrayList<Integer>());
        return paths;
    }

    private void allPaths(Integer from, Integer to, Map<Integer, List<Integer>> map,
                          List<List<Integer>> paths, List<Integer> tempList, List<Integer> visited) {

        if (from == null || to == null) return;

        if (Integer.valueOf(from) == Integer.valueOf(to)) {
            paths.add(new ArrayList(tempList));
            return;
        }

        visited.add(from);

        for (Integer node : map.get(from)) {
            tempList.add(node);
            allPaths(node, to, map, paths, tempList, visited);
            tempList.remove(tempList.size() -1);
        }
        visited.remove(from);
    }

    public Map<Integer, List<Integer>> populate() {

        int[][] graph = {{1,2},{3},{}};

        Map<Integer, List<Integer>> map = new HashMap();

        for (int i = 0; i < graph.length; i++) {
            map.put(i, new ArrayList<Integer>());
            for (int j = 0; j < graph[i].length; j++) {
                map.get(i).add(graph[i][j]);
            }
        }

        return map;
    }
}
