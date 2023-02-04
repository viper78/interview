package blind75;

public class TreeMaxPathSum {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxSum;
    }

    public int helper(TreeNode root) {
        if (root == null) return 0;

        int left = helper(root.left);
        int right = helper(root.right);

        maxSum = Math.max(maxSum, left + right + root.val);

        return Math.max(left, right) + root.val;
    }
}
