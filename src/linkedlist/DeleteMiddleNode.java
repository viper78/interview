package linkedlist;

public class DeleteMiddleNode {

    public static void main(String[] args) {
        String[] data = new String[]{"car", "bus", "truck", "bike", "car", "truck"};

        LinkedListNode head = createLinkedListFromArray(data);
        System.out.println(head.printNodes());

        head = deleteMiddleNode(head);
        System.out.println(head.printNodes());
    }

    private static LinkedListNode deleteMiddleNode(LinkedListNode node) {
        LinkedListNode head = node;
        LinkedListNode fast = node;
        LinkedListNode slow = node;
        LinkedListNode middle = node;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            middle = slow;
            slow = slow.next;
        }

        middle.next = slow.next;
        return head;
    }


    private static LinkedListNode createLinkedListFromArray( String[] data ) {
        LinkedListNode head = new LinkedListNode( data[0], null, null );
        LinkedListNode current = head;
        for (int i = 1; i < data.length; i++) {
            current = new LinkedListNode( data[i], null, current );
        }
        return head;

    }
}
