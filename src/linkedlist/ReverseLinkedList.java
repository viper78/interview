package linkedlist;

public class ReverseLinkedList {

    public static void main(String[] args) {

       ReverseLinkedList r = new ReverseLinkedList();
       Node root = r.loadData();

       //r.recursive(root);

       root = r.reverse(root);

       while (root!= null) {
           System.out.print(root.data + "->");
           root = root.next;
       }

    }

    private void recursive(Node node) {
        if (node != null) {
            recursive(node.next);
            System.out.print(node.data + " -> ");
        }
    }

    //Before changing next of current,
// store next node
    //next = curr->next

// This is where actual reversing happens
    //curr->next = prev

// Move prev and curr one step forward
      //      prev = curr
    //curr = next
    private Node reverse(Node node) {
        Node prev = null;
        Node next = null;
        Node current = node;

        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }



    private Node loadData() {

        Node root = new Node(1);
        root.next = new Node(2);
        root.next.next = new Node(3);
        root.next.next.next = null;

        return root;
    }

    private class Node {
        int data;
        Node next;

        Node (int data) {
            this.data = data;
        }
    }

}

