package blind75;

public class isValidBST {
    public boolean isValidBST(TreeNode root) {

        return isValidBST(root, null, null);
    }

    public boolean isValidBST(TreeNode root, Integer min, Integer max) {

        if (root == null) {
            return true;
        } else if (min != null && min > root.val || max != null && max < root.val) {
            return false;
        } else {
            return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
        }
    }
}
