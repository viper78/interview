package tree;

public class Subtree {

    public static void main(String[] args) {
        int[] array1 = {1, 2, 1, 3, 1, 1, 5};
        int[] array2 = {2, 3, 1};
        int[] array3 = {1, 2, 3};

        btree.Tree t1 = createMinimalBST(array1);
        btree.Tree t2 = createMinimalBST(array3);
        System.out.println(isSubTree(t1, t2));
    }

    private static boolean isSubTree(btree.Tree t1, btree.Tree t2) {

        StringBuilder b1 = new StringBuilder();
        StringBuilder b2 = new StringBuilder();

        System.out.println(preOrderTraversal(t1, b1));
        System.out.println(preOrderTraversal(t2, b2));

        return (b1.toString().contains(b2.toString()));
    }

    static String preOrderTraversal(btree.Tree node, StringBuilder builder) {

        if (node != null) {
            builder.append(node.data);
            builder.append(",");
            preOrderTraversal(node.left, builder);
            preOrderTraversal(node.right, builder);
        }
        return builder.toString();
    }

    public static btree.Tree createMinimalBST(int[] arr) {

        return createMinimalBST(arr, 0, arr.length-1);
    }

    private static btree.Tree createMinimalBST(int[] arr, int start, int end) {

        if (end < start) return null;

        int mid = (start + end)/2;
        btree.Tree node = new btree.Tree(arr[mid]);
        node.setLeft(createMinimalBST(arr, start, mid-1));
        node.setRight(createMinimalBST(arr, mid + 1, end));
        return node;
    }


}
