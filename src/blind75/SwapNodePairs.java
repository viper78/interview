package blind75;

public class SwapNodePairs {

    //https://leetcode.com/problems/swap-nodes-in-pairs/

    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode temp = new ListNode(-1);
        temp.next = head;
        ListNode current = temp;

        while (current.next != null && current.next.next != null) {

            ListNode firstNode = current.next;
            ListNode secondNode = current.next.next;
            firstNode.next = secondNode.next;
            current.next = secondNode;
            current.next.next = firstNode;
            current = current.next.next;
        }

        return temp.next;
    }
}
