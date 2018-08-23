package linkedlist;

//O(N + k)
public class SplitLinkedList {

    public static void main (String[] args) {

        SplitLinkedList mc = new SplitLinkedList();
        Node head = mc.populate();

        int k = 2;

        Node[] nodes = mc.splitList(head, k);

        for (Node n : nodes) {
            System.out.println(n.val);
        }
    }

    public Node[] splitList(Node head, int k) {

        Node[] nodes = new Node[k];

        if (head == null)
            return nodes;

        Node temp = head;
        int count = 0;

        while (temp != null) {
            temp = temp.next;
            count++;
        }

        int itemsPerK = 0;

        itemsPerK = count/k;

        int remainder = count%k;


        for (int i = 0; i < k; i++) {

            Node itemHead = new Node(0);
            Node current = itemHead;

            for (int j = 0; j < itemsPerK + ((i < remainder) ? 1 : 0); j++) {

                current.next = new Node(head.val);
                current = current.next;
                if (head != null) {
                    head = head.next;
                }

            }
            nodes[i] = itemHead.next;
        }

        return nodes;
    }

    public Node populate() {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        return head;
    }

    public class Node {
     int val;
     Node next;
     Node(int x) { val = x; }
 }
}
