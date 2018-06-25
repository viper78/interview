package linkedlist;

public class ReverseKNodes {

    public static void main (String[] args) {

        ReverseKNodes mc = new ReverseKNodes();

        LinkNode root = mc.populate();

        LinkNode head = mc.reverseK(root, 4);

        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
    }

    public LinkNode reverseK(LinkNode node, int k) {

        LinkNode prev = null;
        LinkNode next = null;
        LinkNode current = node;

        int i = 0;
        while(current != null && i < k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            i++;
        }

        if (next != null) {
            node.next = reverseK(next, k);
        }

        return prev;

    }

    public LinkNode populate() {

        LinkNode root = new LinkNode(1);
        root.next = new LinkNode(2);
        root.next.next = new LinkNode(3);
        root.next.next.next = new LinkNode(4);
        root.next.next.next.next = new LinkNode(5);
        root.next.next.next.next.next = new LinkNode(6);

        return root;
    }

    class LinkNode {
        int val;
        LinkNode next;

        public LinkNode(int val) {
            this.val = val;
        }
    }

}
