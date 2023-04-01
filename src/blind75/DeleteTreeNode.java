package blind75;

public class DeleteTreeNode {

    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null) return root;

        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            root.val = minValue(root.right);
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    int minValue(TreeNode node) {
        if (node == null) return -1;
        if (node.left == null) {
            return node.val;
        }
        return minValue(node.left);
    }
}
