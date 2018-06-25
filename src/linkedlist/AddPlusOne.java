package linkedlist;

public class AddPlusOne {

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(9);
        head.next = new Node(9);
        head.next.next = new Node(9);

        head = plusOne(head);

        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
    }

    private static Node plusOne(Node head) {

        if (head == null) return head;

        int carry = getPlusOne(head);
        if (carry != 0) {
            Node first = new Node(carry);
            first.next = head;
            head = first;
        }
        return head;
    }

    private static int getPlusOne(Node head) {

        if (head == null) return 1;

        int carry = getPlusOne(head.next);
        int sum = head.val + carry;
        head.val = sum % 10;

        return sum/10;
    }
}
