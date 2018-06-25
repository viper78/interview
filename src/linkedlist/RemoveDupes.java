package linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by rajeshsubramanian on 3/15/18.
 */
public class RemoveDupes {

    public static void main( String[] args ) {

        String[] data = new String[]{"car", "bus", "truck", "bike", "car", "truck"};

        LinkedListNode firstNode = new LinkedListNode( "first" );
        LinkedListNode head = firstNode;
        LinkedListNode temp = firstNode;
        for (String d : data) {
            temp = new LinkedListNode( d );
            temp.setPrev( firstNode );
            firstNode.setNext( temp );
            firstNode = temp;
        }
        System.out.println(head.printFoward());
        removedups(head);
        System.out.println(head.printFoward());

    }

    private static void removedups( LinkedListNode node ) {

        Set<String> linkedListNodeSet = new HashSet<>();
        LinkedListNode temp = null;
        while (node != null) {
            if (linkedListNodeSet.contains( node.data )) {
                temp.next = node.next;
            } else {
                linkedListNodeSet.add( node.data );
                temp = node;
            }
            node = node.next;
        }
    }

}
