package linkedlist;

/**
 * Created by rajeshsubramanian on 3/16/18.
 */
public class CircularLinkedList {

    public static void main( String[] args ) {
        int len = 15;
        int meet = 5;
        LinkedListNode[] nodes = new LinkedListNode[len];

        for (int i = 0; i < len; i++) {
            nodes[i] = new LinkedListNode( Integer.toString( i ), null, i > 0 ?nodes[i-1]: null);
        }
        System.out.println(nodes[0].printNodes());
        nodes[len-1].next = nodes[meet];

        System.out.println(findMeetingNode( nodes[0] ).data);

    }

    private static LinkedListNode findMeetingNode( LinkedListNode node ) {
        LinkedListNode head = node;
        LinkedListNode slow = head;
        LinkedListNode fast = head;

        while ( fast != null && fast.next != null ) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        slow = head;
        while (slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (slow == fast) {
                break;
            }
        }
        return fast;
    }
}
