package tree;

public class SplitTree {

    /* Because this recursive function will always
    return TreeNode[0] and TreeNode[1],
    TreeNode[0] will be the result that node value <= V and TreeNode[1] will contains all the node that value > V
     */
//*

    public static void main(String[] args) {

       SplitTree st = new SplitTree();
       Tree root = st.populate();
       Tree[] trees = st.split(root, 5);
       System.out.println(trees);
    }


    public Tree[] split(Tree root, int k) {

        if (root == null) {
            return new Tree[] {null, null};
        }

        if (root.val > k) {
            Tree[] nodes = split(root.left, k);
            root.left = nodes[1];
            return new Tree[] {nodes[0], root};
        } else {
            Tree[] nodes = split(root.right, k);
            root.right = nodes[0];
            return new Tree[] {root, nodes[1]};
        }
    }


    public Tree populate() {
        Tree root = new Tree(5);
        root.left = new Tree(3);
        root.left.left = new Tree(1);
        //root.left.right = new Tree(2);
        root.right = new Tree(7);
        root.right.left = new Tree(6);
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
