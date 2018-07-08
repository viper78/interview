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
        slow.next = null;

        LinkNode prev = null;
        LinkNode next = null;
        LinkNode current = newHead;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        newHead = prev;

        LinkNode merged = new LinkNode(0);
        LinkNode curr = merged;
        while (head != null || newHead != null) {

            if (head != null) {
                curr.next = head;
                head = head.next;
                curr = curr.next;
            }

            if (newHead != null) {
                curr.next = newHead;
                newHead = newHead.next;
                curr = curr.next;
            }
        }

        return merged.next;
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
