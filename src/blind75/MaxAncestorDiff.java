package blind75;

public class MaxAncestorDiff {
    public int maxAncestorDiff(TreeNode root) {
        return helper(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    public int helper(TreeNode root, int min, int max) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        min = Math.min(min, root.val);
        max = Math.max(max, root.val);

        int left = helper(root.left, min, max);
        int right = helper(root.right, min, max);

        return Math.max(max - min, Math.max(left, right));
    }
}
