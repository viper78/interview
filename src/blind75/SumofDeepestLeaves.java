package blind75;

import java.util.LinkedList;
import java.util.Queue;

public class SumofDeepestLeaves {

    public int deepestLeavesSum(TreeNode root) {

        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        int maxSum = Integer.MIN_VALUE;
        queue.add(root);

        while (!queue.isEmpty()) {

            int currentSum = 0;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                currentSum += node.val;

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            maxSum = currentSum;
        }

        return maxSum;
    }
}
