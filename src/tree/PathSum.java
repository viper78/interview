package tree;

public class PathSum {

    public static void main(String[] args) {

        PathSum ps = new PathSum();
        TreeNode root = ps.populate();
        boolean flag = ps.isPath(root, 26);
        System.out.println(flag);
    }

    private boolean isPath(TreeNode root, int sum) {

        if (root == null) return false;

        return isPath(root, 0, sum);
    }

    private boolean isPath(TreeNode root, int currentSum, int totalSum) {

        if (currentSum == totalSum) return true;

        if (root != null) {
            currentSum += root.data;
            if (isPath(root.left, currentSum, totalSum) || isPath(root.right, currentSum, totalSum)) {
                return true;
            }
        }
        return false;
    }

    public TreeNode populate() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        return root;
    }

    class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }

}


