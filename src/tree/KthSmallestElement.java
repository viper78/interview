package tree;

import java.util.Stack;

import static tree.TreeTester.createMinimalBST;

public class KthSmallestElement {

    public static void main(String[] args) {
        KthSmallestElement smallestElement = new KthSmallestElement();
        Tree root = smallestElement.populate();
        System.out.println(smallestElement.kthSmallest(root, 2));
        System.out.println(smallestElement.kthLargest(root, 2));
    }

    public Tree populate() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Tree root = createMinimalBST(array);
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

    public int kthSmallest(Tree root, int k) {
        Stack<Tree> st = new Stack<>();

        while (root != null) {
            st.push(root);
            root = root.left;
        }

        while (k != 0) {
            Tree n = st.pop();
            k--;
            if (k == 0) return n.data;
            Tree right = n.right;
            while (right != null) {
                st.push(right);
                right = right.left;
            }
        }

        return -1; // never hit if k is valid
    }

    public int kthLargest(Tree root, int k) {
        Stack<Tree> st = new Stack<>();

        while (root != null) {
            st.push(root);
            root = root.right;
        }

        while (k != 0) {
            Tree n = st.pop();
            k--;
            if (k == 0) return n.data;
            n = n.left;
            while (n != null) {
                st.push(n);
                n = n.right;
            }
        }

        return -1; // never hit if k is valid
    }
}
