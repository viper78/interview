package tree;

/**
 * Created by rajeshsubramanian on 3/17/18.
 */
public class TreeNode {

    int data;
    int size = 0;
    TreeNode left;
    TreeNode right;
    TreeNode parent;

    TreeNode(int data) {
        this.data = data;
        size = 1;
    }

    public void setLeft( TreeNode left ) {
        this.left = left;
        if (left != null) {
            left.parent = this;
        }
    }

    public void setRight( TreeNode right ) {
        this.right = right;
        if (right != null) {
            right.parent = this;
        }
    }

    public void inorderAddition(int d) {
        if (d < data) {
            if (left != null) {
                left.inorderAddition( d );
            } else {
                setLeft( new TreeNode( d ) );
            }
        } else {
            if (right != null) {
                right.inorderAddition( d );
            } else {
                setRight( new TreeNode( d ) );
            }
        }

        size++;
    }

    public boolean isBST() {
        if (data < left.data || !left.isBST()) {
            return false;
        }
        if (data > right.data || !right.isBST()) {
            return false;
        }
        return true;
    }

    public static TreeNode createMinimalBST(int[] arr, int start, int end) {

        if (start > end) {
            return null;
        }
        int mid = (start + end)/2;
        TreeNode node = new TreeNode(arr[mid]);
        node.setLeft(createMinimalBST(arr, start, mid -1));
        node.setRight(createMinimalBST(arr, mid + 1, end));
        return node;

    }


}
