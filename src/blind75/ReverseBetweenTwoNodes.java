package blind75;

public class ReverseBetweenTwoNodes {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null) {
            return null;
        }

        ListNode prev = null;
        ListNode current = head;
        while (left > 1) {
            prev = current;
            current = current.next;
            left--;
            right--;
        }

        ListNode link = prev;
        ListNode tail = current;

        while (right > 0) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            right--;
        }

        if (link != null) {
            link.next = prev;
        } else {
            head = prev;
        }
        tail.next = current;

        return head;
    }
}
