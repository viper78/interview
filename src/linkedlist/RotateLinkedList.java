package linkedlist;

public class RotateLinkedList {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        Node n = rotateRight(head, 2);

        while(n != null) {
            System.out.print(n.data + "->");
            n = n.next;
        }
    }

    public static Node rotateRight(Node head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        Node slow = head;
        Node fast = head;

        int i = 0;
        while (i < k && fast != null) {
            fast = fast.next;
            i++;
        }

        if (fast == null) {
            int t = k % i;
            return rotateRight(head, t);
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        Node next = slow.next;
        slow.next = null;
        fast.next = head;
        return next;
    }

    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }
}
