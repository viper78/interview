package tree;


import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

public class TreeTester {

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        int[] array = {1,3,4,5,2,9,8};

//                     5
//                   /   \
//                 2      8
//                / \    / \
//               1   3  6   9
//                    \  \   \
//                     4  7   10



        Tree root = createMinimalBST(array);
//        inorderTraversal(root);
//        System.out.println();
//        preorderTraversal(root);
//        System.out.println();
//        bfs(root);
//
//        System.out.println(isBST(root));
//        System.out.println(height(root));
//
//        System.out.println(find(root, 11));

//        System.out.println(commonAncestor(root, 7, 10).data);

//        inOrder(root).stream().forEach( s-> System.out.println(s));

//        inorderIterative(root);
        preorderIterative(root);
    }

    private static void preorderIterative(Tree root) {
        if (root == null) return;

        Stack<Tree> stack = new Stack();
        stack.push(root);

        while (!stack.isEmpty()) {
            root = stack.pop();
            System.out.print(root.data + " ");

            if (root.left != null) {
                stack.push(root.left);
            }

            if (root.right != null) {
                stack.push(root.right);
            }
        }
    }

    private static void inorderIterative(Tree root) {

        if (root == null) return;

        Stack<Tree> stack = new Stack();
        stack.push(root);

        while (!stack.isEmpty()) {

            while (root != null && root.left != null) {
                root = root.left;
                stack.push(root);
            }
            root = stack.pop();
            System.out.print(root.data + " ");

            root = root.right;
            if (root != null) {
                stack.push(root);
            }
        }
    }


    private static Tree commonAncestor(Tree root, int a, int b) {

        Tree t1 = find(root, a);
        Tree t2 = find(root, b);

        if (a == b) return t1;

        Tree ancestor = t1;
        Tree node = t2;
        while (ancestor != null) {
            while (t2 != null) {
                if (ancestor == t2) {
                    return ancestor;
                }
                t2 = t2.parent;
            }
            t2 = node;
            ancestor = ancestor.parent;
        }

        return null;
    }

    private static Tree find(Tree node, int d) {
        if (node.data == d) {
            return node;
        } else if (node.data < d) {
            return node.right != null ? find(node.right, d) : null;
        } else if (node.data > d) {
            return node.left != null ? find(node.left, d) : null;
        }

        return null;
    }

    private static int height(Tree node) {
        int leftHeight = node.left != null? height(node.left) : 0;
        int rightHeight = node.right != null? height(node.right) : 0;
        return 1 + Math.max(leftHeight, rightHeight);
    }

    private static boolean isBST(Tree root) {
        if (root.left != null) {
            if (root.data < root.left.data && !isBST(root.left)) {
                return false;
            }
        }
        if (root.right != null) {
            if (root.data > root.right.data && !isBST(root.right)) {
                return false;
            }
        }

        return true;
    }

    public static ArrayList inOrder(Tree root){
        ArrayList<Integer> result=new ArrayList();
        if(root != null){
            result.addAll(inOrder(root.left));
            result.add(root.data);
            result.addAll(inOrder(root.right));
        }
        return result;
    }

    private static void inorderTraversal(Tree node) {

        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.data + " ");
            inorderTraversal(node.right);
        }
    }

    private static void preorderTraversal(Tree node) {
        //DFS
        if (node != null) {
            System.out.print(node.data + " ");
            inorderTraversal(node.left);
            inorderTraversal(node.right);
        }
    }

    public static Tree createMinimalBST(int[] arr) {

        return createMinimalBST(arr, 0, arr.length-1);
    }

    private static Tree createMinimalBST(int[] arr, int start, int end) {

        if (end < start) return null;

        int mid = (start + end)/2;
        Tree node = new Tree(arr[mid]);
        node.setLeft(createMinimalBST(arr, start, mid-1));
        node.setRight(createMinimalBST(arr, mid + 1, end));
        return node;
    }

    private static void bfs(Tree root) {
        //BFS
        Queue queue = new LinkedList();
        queue.add(root);

        while (!queue.isEmpty()) {
            Tree node = (Tree)queue.peek();
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            System.out.println(((Tree)queue.poll()).data);
        }


    }
}


