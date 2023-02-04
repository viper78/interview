package blind75;

public class TreePathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {

            if (root == null) {
                return false;
            }
            if (root.val == targetSum) {
                return true;
            }
            return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
