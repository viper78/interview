package linkedlist;

import java.util.Arrays;

/**
 * Created by rajeshsubramanian on 3/21/18.
 */
public class SwapAlternateValues {

    public static void main( String[] args ) {
        populateList();
    }
    private static void populateList() {
        int[] data = new int[]{2,3,4,5};
        MyNode head = new MyNode( 1 );
        MyNode firstNode = head;
        MyNode temp = null;
        for (int d : data) {
            temp = new MyNode( d );
            firstNode.next = temp;
            firstNode = temp;
        }

        MyNode n = head;
        while ( n != null ) {
            System.out.print(n.data + "->");
            n = n.next;
        }

        swapData(head);
        System.out.println();
        while ( head != null ) {
            System.out.print(head.data + "->");
            head = head.next;
        }
    }

    private static void swapData( MyNode node ) {

        while ( node != null && node.next != null ) {
            int data = node.data;
            node.data = node.next.data;
            node.next.data = data;
            node = node.next.next;
        }
    }
}

class MyNode {

    MyNode next;
    int data;

    MyNode(int d) {
        this.data = d;
    }
}
