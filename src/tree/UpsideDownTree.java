package tree;

public class UpsideDownTree {

    public Tree reverse (Tree root) {

        if (root == null) return null;
        if (root.left == null && root.right == null) {
            return root;
        }

        return reverse(root.left, root);
    }

    private Tree reverse(Tree newRoot, Tree oldRoot) {

        if (newRoot == null) return oldRoot;

        newRoot.right = oldRoot;
        newRoot.left = oldRoot.right;
        oldRoot.left = null;
        oldRoot.right = null;

        return reverse(newRoot.left, newRoot);
    }
}
