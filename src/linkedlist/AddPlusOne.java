package linkedlist;

public class AddPlusOne {

    class LinkedListNode {
        int data;
        LinkedListNode next;

        LinkedListNode(int val) {
            this.data = data;
        }
    }

    private  LinkedListNode addTwoLists(LinkedListNode l1, LinkedListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) return null;

        LinkedListNode result = new LinkedListNode(0);
        int sum = 0;
        sum += l1 != null ? l1.data : 0;
        sum += l2 != null ? l2.data : 0;
        sum += carry;

        carry = sum / 10;
        result.data = sum % 10;

        if (l1 != null || l2 != null) {
            LinkedListNode next = addTwoLists( l1 != null? l1.next : null, l2 != null ? l2.next : null, carry );

            result.next = next;
        }

        return result;
    }

}
