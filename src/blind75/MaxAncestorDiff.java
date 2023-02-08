package blind75;

public class MaxAncestorDiff {
    int maxDiff = Integer.MIN_VALUE;
    public int maxAncestorDiff(TreeNode root) {
        if (root == null) return 0;
        dfs(root, root.val, root.val);
        return maxDiff;
    }

    void dfs(TreeNode node, int min, int max) {
        if (node == null) return;

        maxDiff = Math.max(maxDiff, Math.max(Math.abs(min - node.val), Math.abs(max - node.val)));

        min = Math.min(min, node.val);
        max = Math.max(max, node.val);

        dfs(node.left, min, max);
        dfs(node.right, min, max);

    }
}
