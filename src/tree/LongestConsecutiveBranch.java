package tree;

public class LongestConsecutiveBranch {

    public static void main(String[] args) {

        LongestConsecutiveBranch branch = new LongestConsecutiveBranch();
        Node root = branch.populate();
        System.out.println(branch.consecutive(root));
    }

    private int consecutive(Node node) {
        if (node == null ) return 0;

        return Math.max(consecutive(node.left, node.data, 1), consecutive(node.right, node.data, 1));
    }

    private int consecutive(Node node, int prevData, int len) {

        if (node == null) return len;

        if (node.data == prevData + 1) {
            int leftLen = consecutive(node.left, node.data, len + 1);
            int rightLen = consecutive(node.right, node.data, len + 1);

            return Math.max(leftLen, rightLen);
        } else {
            int leftLen = consecutive(node.left, node.data, len);
            int rightLen = consecutive(node.right, node.data, len);

            return Math.max(leftLen, rightLen);
        }

    }

    private Node populate() {

        Node root = new Node(0);
        root.left = new Node(1);
        root.right = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(2);
        root.right.left = new Node(1);
        root.right.right = new Node(3);

        return root;
    }

    class Node {
        int data;
        Node left;
        Node right;
        Node (int data) {
            this.data = data;
        }
    }

}

