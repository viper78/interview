package tree;

public class Tree<T extends Comparable>{

    Tree left;
    Tree right;
    Tree parent;
    int data;

    public Tree (int data) {
        this.data = data;
    }

    public void setLeft(Tree left) {

        if (left != null) {
            this.left = left;
            left.parent = this;
        }
    }

    public void setRight(Tree right) {
        if (right != null) {
            this.right = right;
            right.parent = this;
        }
    }


}
