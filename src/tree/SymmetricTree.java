package tree;

public class SymmetricTree {

    public static void main(String[] args) {

        SymmetricTree st = new SymmetricTree();
        Tree root = st.populate();
        boolean flag = st.isSymmetric(root, root);
        System.out.println(flag);
    }

    private boolean isSymmetric(Tree node1, Tree node2) {

        if (node1 == null && node2 == null) return true;

        if (node1 != null && node2 != null && node1.val == node2.val) {
            return isSymmetric(node1.left, node2.right) && isSymmetric(node1.right, node2.left);
        }

        return false;
    }

    public Tree populate() {
        Tree root = new Tree(5);
        root.left = new Tree(3);
        root.left.left = new Tree(1);
        //root.left.right = new Tree(2);
        root.right = new Tree(3);
        root.right.right = new Tree(1);
        //  root.right.right = new Tree(8);

        return root;
    }

    class Tree {
        int val;
        Tree left;
        Tree right;

        Tree(int val) {
            this.val = val;
        }
    }
}
