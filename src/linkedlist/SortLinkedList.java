package linkedlist;

public class SortLinkedList {

    public static void main( String[] args ) {
        SortLinkedList eo = new SortLinkedList();
        LinkNode head = eo.populate();
        LinkNode newHead = eo.merge(head);

        while (newHead != null) {
            System.out.print(newHead.data + "->");
            newHead = newHead.next;
        }
    }

    public LinkNode merge(LinkNode head) {
        LinkNode oldHead = head;
        if (oldHead == null || oldHead.next == null) return head;

        LinkNode middle = getMiddle(oldHead);
        LinkNode nextToMiddle = middle.next;
        middle.next = null;

        LinkNode left = merge(oldHead);
        LinkNode right = merge(nextToMiddle);

        LinkNode merged = mergeSort(left, right);

        return merged;
    }

    private LinkNode mergeSort(LinkNode left, LinkNode right) {

        if (left == null) return right;
        if (right == null) return left;

        LinkNode result = null;
        if (left.data <= right.data) {
            result = left;
            result.next = mergeSort(left.next, right);
        } else {
            result = right;
            result.next = mergeSort(left, right.next);
        }

        return result;
    }

    private LinkNode getMiddle(LinkNode head) {

        LinkNode fast = head;
        LinkNode slow = head;

        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }


    private LinkNode populate() {

        LinkNode head = new LinkNode( 1 );
        head.next = new LinkNode( 3 );
        head.next.next = new LinkNode( 2 );
        head.next.next.next = new LinkNode( 5 );
        head.next.next.next.next = new LinkNode( 4 );

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
