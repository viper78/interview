package linkedlist;

public class EvenOddList {
    public static void main( String[] args ) {
        EvenOddList eo = new EvenOddList();
        LinkNode head = eo.populate();
        LinkNode newHead = eo.evenOdd(head);

        while (newHead != null) {
            System.out.print(newHead.data + "->");
            newHead = newHead.next;
        }
    }

    private LinkNode evenOdd( LinkNode head ) {

        LinkNode l1 = head;
        LinkNode l2 = head.next;
        LinkNode next = head.next;

        while (l1 != null && l2 != null) {
            LinkNode temp = l2.next;
            if (temp == null)
                break;
            l1.next = temp;
            l1 = l1.next;

            l2.next = l1.next;
            l2 = l2.next;
        }
        l1.next = next;

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



