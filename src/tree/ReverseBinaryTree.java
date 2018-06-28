package tree;

import static tree.Subtree.createMinimalBST;

public class ReverseBinaryTree {

    public static void main(String[] args) {

        int[] array1 = {1, 2, 1, 3, 1, 1, 5};

        Tree t1 = createMinimalBST(array1);

        reverseTree(t1);
    }

    private static void reverseTree(Tree root) {

        if (root == null) return;

        Tree temp = root.right;
        root.right = root.left;
        root.left = temp;

        reverseTree(root.left);
        reverseTree(root.right);
    }
}
