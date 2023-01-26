package blind75;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode prevNode = null;

        while (head != null) {
            ListNode nextNode = head.next;
            head.next = prevNode;
            prevNode = head;
            head = nextNode;
        }

        return prevNode;
    }
}
  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

