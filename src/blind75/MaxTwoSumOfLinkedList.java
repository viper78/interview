package blind75;

public class MaxTwoSumOfLinkedList {
    public int pairSum(ListNode head) {

        int maxSum = 0;
        if (head == null) {
            return maxSum;
        }

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

        return maxSum(l1Head, l2Head);


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

    public int maxSum(ListNode l1, ListNode l2) {
        int maxSum = 0;

        while (l1 != null && l2 != null) {
            maxSum = Math.max(maxSum, l1.val + l2.val);
            l1 = l1.next;
            l2 = l2.next;
        }
        return maxSum;

    }
}
