package blind75;

public class ReorderLinkedList {

    public void reorderList(ListNode head) {

        if (head == null) return;
        // Start of first list
        ListNode l1Head = head;
        // Start of second list
        ListNode slow = head;
        // Tail of second list
        ListNode fast = head;
        // Tail of first list
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;

        ListNode l2Head = reverse(slow);

        merge(l1Head, l2Head);
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while(head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public void merge(ListNode l1, ListNode l2) {

        while (l1 != null && l2 != null) {
            ListNode l1Next = l1.next;
            ListNode l2next = l2.next;

            l1.next = l2;
            if (l1Next == null)
                break;

            l2.next = l1Next;
            l1 = l1Next;
            l2 = l2next;
        }
    }
}

