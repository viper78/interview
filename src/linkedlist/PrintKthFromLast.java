package linkedlist;

/**
 * Created by rajeshsubramanian on 3/15/18.
 */
public class PrintKthFromLast {

    public static void main( String[] args ) {

        String[] data = new String[]{"car", "bus", "truck", "bike", "car", "truck"};

        LinkedListNode head = createLinkedListFromArray(data);
        System.out.println(head.printNodes());
        PrintKthFromLast printKthFromLast = new PrintKthFromLast();
        int k = 2;
        System.out.println(printKthFromLast.printKthNode(head, k));
    }

    private static LinkedListNode createLinkedListFromArray( String[] data ) {
        LinkedListNode head = new LinkedListNode( data[0], null, null );
        LinkedListNode current = head;
        for (int i = 1; i < data.length; i++) {
            current = new LinkedListNode( data[i], null, current );
        }
        return head;

    }

    private String printKthNode( LinkedListNode head, int k ) {

        LinkedListNode node1 = head;
        LinkedListNode node2 = head;

        for (int i = 0; i < k; i++) {
            if (node1 != null) {
                node1 = node1.next;
            }
        }

        while (node1 != null ) {
            node1 = node1.next;
            node2 = node2.next;
        }

        return node2.data;
    }

}
