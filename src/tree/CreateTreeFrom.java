package tree;

public class CreateTreeFrom {

    public static void main(String[] args) {
        CreateTreeFrom tree = new CreateTreeFrom();
        int in[] = new int[]{4, 8, 2, 5, 1, 6, 3, 7};
        int post[] = new int[]{8, 4, 5, 2, 6, 7, 3, 1};
        int n = in.length;
        Node root = tree.buildTree(in, post, n);
        System.out.println("Preorder of the constructed tree : ");
        tree.preOrder(root);
    }

    Node buildTree(int in[], int post[], int n) {
        int[] pIndex = {n-1};
        return buildTree(in, post, 0, n - 1, pIndex);
    }

    Node buildTree(int in[], int post[], int inStrt,
                   int inEnd, int[] pIndex)    {
        // Base case
        if (inStrt > inEnd)
            return null;

        /* Pick current node from Postrder traversal using
           postIndex and decrement postIndex */
        Node node = new Node(post[pIndex[0]]);
        (pIndex[0])--;

        /* If this node has no children then return */
        if (inStrt == inEnd)
            return node;

        /* Else find the index of this node in Inorder
           traversal */
//            int iIndex = search(in, inStrt, inEnd, node.data);
        int iIndex = 0;
        for (int i = 0; i < in.length; i++) {
            if (in[i] == node.data) {
                iIndex = i;
                break;
            }
        }

        /* Using index in Inorder traversal, construct left and
           right subtress */
        node.right = buildTree(in, post, iIndex + 1, inEnd, pIndex);
        node.left = buildTree(in, post, inStrt, iIndex - 1, pIndex);

        return node;
    }

    // This function mainly initializes index of root
    // and calls buildTree()


    class Node {
        int data;
        Node left, right;

        public Node(int data)
        {
            this.data = data;
            left = right = null;
        }
    }

    // Class Index created to implement pass by reference of Index


    /* This funtcion is here just to test  */
    void preOrder(Node node)
    {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }


}
