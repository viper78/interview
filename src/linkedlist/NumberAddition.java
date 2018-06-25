package linkedlist;

/**
 * Created by rajeshsubramanian on 3/15/18.
 */
public class NumberAddition {

    public static void main( String[] args ) {

        String[] data = new String[]{"4", "9"};

        LinkedListNode node1 = new LinkedListNode( "3" );
        LinkedListNode head1 = populate( data, node1 );
        System.out.println(head1.printNodes());

        String[] data2 = new String[]{"0", "3"};

        LinkedListNode node2 = new LinkedListNode( "2" );
        LinkedListNode head2 = populate( data2, node2 );
        System.out.println(head2.printNodes());

        addNodes(head1, head2);
    }

    private static void addNodes( LinkedListNode head1, LinkedListNode head2 ) {

        LinkedListNode node1 = head1;
        LinkedListNode node2 = head2;
        int carry = 0;

        while ( node1.next != null ) {
            node1 = node1.next;
        }

        while ( node2.next != null ) {
            node2 = node2.next;
        }

        LinkedListNode current = new LinkedListNode( "0" );
        LinkedListNode temp = current;
        while ( node1 !=null && node2 != null ) {
            int sum = Integer.valueOf( node1.data ) + Integer.valueOf( node2.data) + carry;
            carry = sum/10;
            current.data = Integer.toString(sum%10);
            System.out.print( current.data + " ");

            node1 = node1.prev;
            node2 = node2.prev;
        }

    }

    private static LinkedListNode populate( String[] data, LinkedListNode firstNode ) {
        LinkedListNode head = firstNode;
        LinkedListNode temp = firstNode;
        for (String d : data) {
            temp = new LinkedListNode( d );
            temp.setPrev( firstNode );
            firstNode.setNext( temp );
            firstNode = temp;
        }
        return head;
    }
}