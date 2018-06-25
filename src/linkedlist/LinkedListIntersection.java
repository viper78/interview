package linkedlist;

/**
 * Created by rajeshsubramanian on 3/16/18.
 */
public class LinkedListIntersection {

    public static void main( String[] args ) {

        int arr1[] = new int[]{10, 20, 30, 40, 50, 60, 70};
        int arr2[] = new int[]{100, 200, 300};

        LinkedListNode link1 = createLinkedList(arr1);
        LinkedListNode link2 = createLinkedList(arr2);
        System.out.println(link1.printNodes());
        System.out.println(link2.printNodes());

        link1.next.next.next = link2.next;

        System.out.println(link1.printNodes());

        LinkedListNode intersection = findIntersection(link1, link2);
        System.out.println("Intersection:" + intersection.printNodes());
    }

    private static LinkedListNode findIntersection( LinkedListNode link1, LinkedListNode link2 ) {

        int sizeOfLink1 = 1;
        LinkedListNode current1 = link1;
        while (current1.next != null ) {
            current1 = current1.next;
            sizeOfLink1++;
        }
        System.out.println("Link 1 size:"+ sizeOfLink1);

        int sizeOfLink2 = 1;
        LinkedListNode current2 = link2;
        while (current2.next != null ) {
            current2 = current2.next;
            sizeOfLink2++;
        }
        System.out.println("Link 2 size:"+ sizeOfLink2);
        // Check for intersection.
        if (current1.data != current2.data) {
            return null;
        }

        LinkedListNode longer = null;
        LinkedListNode shorter = null;

        if (sizeOfLink1 > sizeOfLink2) {
            longer = link1;
            shorter = link2;
        } else {
            longer = link2;
            shorter = link1;
        }

        //advance the longer linkedlist by the difference
        for (int i = 0; i < Math.abs( sizeOfLink1 - sizeOfLink2 ); i++) {
            if (longer != null) {
                longer = longer.next;
            }
        }

        while (shorter != longer) {
            shorter = shorter.next;
            longer = longer.next;
        }

        return longer;
    }

    private static LinkedListNode createLinkedList( int[] arr ) {
        LinkedListNode head = new LinkedListNode( Integer.toString(arr[0]), null, null );
        LinkedListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current = new LinkedListNode( Integer.toString( arr[i] ), null, current );
        }

        return head;
    }
}
