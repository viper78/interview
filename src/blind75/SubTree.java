package blind75;

public class SubTree {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if (root == null) {
            return false;
        } else if (isSametree(root, subRoot)) {
            return true;
        } else {
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }
    }

    public boolean isSametree(TreeNode root, TreeNode subRoot) {

        if (root == null || subRoot == null) {
            return root == null && subRoot == null;
        }

        if (root.val == subRoot.val) {
            return isSametree(root.left, subRoot.left) && isSametree(root.right, subRoot.right);
        } else {
            return false;
        }
    }

}
