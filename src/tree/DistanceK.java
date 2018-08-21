package tree;

import java.util.*;

public class DistanceK {

    Map<TreeNode, TreeNode> parent;

    public static void main(String[] args) {
        DistanceK obj = new DistanceK();
        System.out.println(obj.distanceK(2));
    }

    public List<Integer> distanceK(int K) {


        TreeNode root = new TreeNode(3);
        TreeNode target = root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);


        target.left = new TreeNode(6);
        target.right = new TreeNode(2);
        target.right.left = new TreeNode(7);
        target.right.right = new TreeNode(4);


        parent = new HashMap();
        dfs(root, null);

        Queue<TreeNode> queue = new LinkedList();
        queue.add(null);
        queue.add(target);

        Set<TreeNode> visited = new HashSet();
        visited.add(target);
        visited.add(null);

        int dist = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {

                if (!visited.contains(node.left)) {
                    visited.add(node.left);
                    queue.offer(node.left);
                }
                if (!visited.contains(node.right)) {
                    visited.add(node.right);
                    queue.offer(node.right);
                }
                TreeNode par = parent.get(node);
                if (!visited.contains(par)) {
                    visited.add(par);
                    queue.offer(par);
                }

            } else {
                if (dist == K) {
                    List<Integer> ans = new ArrayList();
                    for (TreeNode n: queue)
                        ans.add(n.val);
                    return ans;
                }
                queue.offer(null);
                dist++;
            }
        }

        return new ArrayList<Integer>();
    }

    public void dfs(TreeNode node, TreeNode par) {
        if (node != null) {
            parent.put(node, par);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode (int val) {
            this.val = val;
        }
    }
}
