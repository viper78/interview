package linkedlist;

public class MergeSortedLists {

    public static void main(String[] args) {

        MergeSortedLists ml = new MergeSortedLists();

        ml.populateLists();

    }

    private void populateLists() {

        Node head1 = new Node(1, null);
        head1.next = new Node( 3, null);
        head1.next.next = new Node(5, null);
        head1.next.next.next = new Node(7, null);

        Node head2 = new Node(2, null);
        head2.next = new Node(4, null);
        head2.next.next = new Node(6, null);

        Node merged = merge(head1, head2);

        while (merged != null) {
            System.out.print(merged.data + "->");
            merged = merged.next;
        }


    }

    private Node merge(Node node1, Node node2) {

        Node temp = new Node();
        Node merged = temp;

        while (node1 != null && node2 != null) {
            if (node1.data <= node2.data) {
                temp.next = node1;
                node1 = node1.next;
            } else {
                temp.next = node2;
                node2 = node2.next;
            }
            temp = temp.next;
        }

        merged = merged.next;
        return merged;
    }

    class Node {
        int data;
        Node next;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
        Node () {

        }
    }
}
