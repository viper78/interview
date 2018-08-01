package tree;

import static tree.Subtree.createMinimalBST;

public class TreeDiameter {

    public static void main(String[] args) {
        int[] array1 = {1, 2, 1, 3, 1, 1, 5};

        Tree t1 = createMinimalBST(array1);
        System.out.println(diameter(t1));
    }

    private static int diameter(Tree node) {

        int[] res = {0};
        diameter(node, res);
        return res[0];
    }

    private static int diameter(Tree node, int[] res) {

        if (node == null) {
            return 0;
        }
        int left = diameter(node.left, res);
        int right = diameter(node.right, res);

        int sum = left + right;

        if (res[0] < sum) {
            res[0] = sum;
        }
        return left > right ? left + 1 : right + 1;
    }
}
