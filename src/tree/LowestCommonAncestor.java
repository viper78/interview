package tree;

public class LowestCommonAncestor {

    static class Tree {
        int val;
        Tree left;
        Tree right;

        Tree(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Tree root = new Tree(5);
        root.left = new Tree(3);
        root.left.left = new Tree(1);
        root.left.right = new Tree(2);
        root.right = new Tree(7);
        root.right.left = new Tree(6);
        root.right.right = new Tree(8);

        Tree ancestor = lca(root, root.right.left , root.right.right);

        System.out.println(ancestor.val);

    }

    private static Tree lca(Tree root, Tree n1, Tree n2) {

        if (root == null) return null;

        if (root == n1 || root == n2) return root;

        Tree left = lca(root.left, n1, n2);
        Tree right = lca(root.right, n1, n2);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }
}
