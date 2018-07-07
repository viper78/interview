package linkedlist;

public class ReorderLinkedList {

    public static void main( String[] args ) {
        ReorderLinkedList eo = new ReorderLinkedList();
        LinkNode head = eo.populate();
        LinkNode newHead = eo.reorder(head);

        while (newHead != null) {
            System.out.print(newHead.data + "->");
            newHead = newHead.next;
        }
    }

    public LinkNode reorder(LinkNode head) {

        if (head == null)
            return null;
        LinkNode fast = head;
        LinkNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast == null)
            return head;

        LinkNode newHead = slow.next;
        LinkNode prev = null;
        LinkNode next = null;
        LinkNode current = newHead;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        slow.next = prev;

        LinkNode temp = head.next;

        while (temp.next != null && temp.next.next != null) {
            int data = temp.data;
            temp.data = temp.next.next.data;
            temp.next.next.data = data;
            temp = temp.next;
        }

        return head;
    }

    private LinkNode populate() {

        LinkNode head = new LinkNode( 1 );
        head.next = new LinkNode( 2 );
        head.next.next = new LinkNode( 3 );
        head.next.next.next = new LinkNode( 4 );
        head.next.next.next.next = new LinkNode( 5 );

        return head;
    }

    class LinkNode {
        int data;
        LinkNode next;

        LinkNode (int data) {
            this.data = data;
        }
    }
}
