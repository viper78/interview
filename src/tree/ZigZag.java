package tree;

import java.util.ArrayList;
import java.util.Stack;

public class ZigZag {

    public static void main (String[] args) {

        ZigZag mc = new ZigZag();
        Node root = mc.populate();

        ArrayList<ArrayList<Integer>> result = mc.zigzagLevelOrder(root);

        result.stream().forEach(System.out::println);
    }

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(Node root) {

        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        if(root==null) return result;
        Stack<Node> stack=new Stack<Node>();
        stack.push(root);
        boolean flag=true;
        while(!stack.isEmpty())
        {
            Stack<Node> Tpstack=new Stack<Node>();
            ArrayList<Integer> list=new ArrayList<Integer>();
            while(!stack.isEmpty())
            {
                Node pop=stack.pop();
                list.add(pop.val);
                if(!flag)
                {
                    if(pop.left!=null) Tpstack.push(pop.left);
                    if(pop.right!=null) Tpstack.push(pop.right);
                }else
                {
                    if(pop.right!=null) Tpstack.push(pop.right);
                    if(pop.left!=null) Tpstack.push(pop.left);
                }
            }
            flag=!flag;
            result.add(list);
            stack=Tpstack;
        }
        return result;
    }

    public Node populate() {
        Node root = new Node(1);
        root.left = new Node( 2 );
        root.right = new Node( 3 );
        root.left.left = new Node( 4 );
        root.left.right = new Node( 5 );
        root.right.left = new Node( 6 );
        root.right.right = new Node( 7 );
        return root;
    }

    class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

}
