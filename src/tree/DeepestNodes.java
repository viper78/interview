package tree;

public class DeepestNodes {

    public static void main(String[] args) {
        Tree root = new Tree(5);
        root.left = new Tree(2);
        root.left.left = new Tree(1);
        root.left.right = new Tree(3);
        root.right = new Tree(7);
        root.right.left = new Tree(6);
        root.right.right = new Tree(8);

        int height = height(root);
        System.out.println(height);
        deepestNodes(root, height - 1);
        rightPostOrderTraversal(root);

    }

    public static void rightPostOrderTraversal(Tree node) {

        if (node == null) return;

        rightPostOrderTraversal(node.right);
        System.out.print(node.val + " ");
        rightPostOrderTraversal(node.left);
    }

    private static void deepestNodes(Tree root, int levels) {

        if (root == null) return;

        if (levels == 1) {
            System.out.println(root.val);
        }
        if (levels > 1) {
            deepestNodes(root.left, levels - 1);
            deepestNodes(root.right, levels - 1);
        }

    }

    private static int height(Tree node) {

        int left = node != null ? height(node.left) : 0;
        int right = node != null ? height(node.right) : 0;

        return  1 + Math.max(left, right);
    }

    static class Tree {
        int val;
        Tree left;
        Tree right;

        Tree(int val) {
            this.val = val;
        }
    }
}
