package blind75;

public class MergeTwoLinkedList {

    ListNode solution(ListNode l1, ListNode l2) {


        ListNode dummy = new ListNode(0);
        ListNode head = dummy;

        while (l1 != null && l2 != null) {

            ListNode node = new ListNode(-1);
            if (l1.val < l2.val) {
                node.val = l1.val;
                l1 = l1.next;
            } else {
                node.val = l2.val;
                l2 = l2.next;
            }
            dummy.next = node;
            dummy = dummy.next;
        }

        while (l1 != null) {
            ListNode node = new ListNode(l1.val);
            l1 = l1.next;
            dummy.next = node;
            dummy = dummy.next;
        }

        while (l2 != null) {
            ListNode node = new ListNode(l2.val);
            l2 = l2.next;
            dummy.next = node;
            dummy = dummy.next;
        }

        return head.next;
    }
}
