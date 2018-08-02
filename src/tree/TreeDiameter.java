package tree;

import static tree.Subtree.createMinimalBST;

public class TreeDiameter {

    public static void main(String[] args) {
        int[] array1 = {1, 2, 1, 3, 1, 1, 5};

        Tree t1 = createMinimalBST(array1);
        System.out.println(diameterOfBinaryTree(t1));
    }

    public static int diameterOfBinaryTree(Tree node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = heightOfBinaryTree(node.left);
        int rightHeight = heightOfBinaryTree(node.right);

        int leftDiameter = diameterOfBinaryTree(node.left);
        int rightDiameter = diameterOfBinaryTree(node.right);

        return Math.max(leftHeight + rightHeight + 1,
                Math.max(leftDiameter, rightDiameter));
    }

    public static int heightOfBinaryTree(Tree node) {
        if (node == null) {
            return 0;
        }
        else {
            return 1 +
                    Math.max(heightOfBinaryTree(node.left),
                            heightOfBinaryTree(node.right));
        }
    }
}
