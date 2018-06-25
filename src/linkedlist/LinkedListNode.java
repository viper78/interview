package linkedlist;

/**
 * Created by rajeshsubramanian on 3/15/18.
 */
public class LinkedListNode {

    LinkedListNode next;
    LinkedListNode prev;
    String data;

    public LinkedListNode(String data) {
        this.data = data;
    }

    public LinkedListNode(String data, LinkedListNode next, LinkedListNode prev) {
        this.data = data;
        setPrev(prev);
        setNext(next);
    }

    public void setNext(LinkedListNode node) {
        if (node != null) {
            this.next = node;
            node.prev = this;
        }
    }

    public void setPrev(LinkedListNode node) {
        if (node != null) {
            this.prev = node;
            node.next = this;
        }
    }

    public String printFoward() {
        if (next != null) {
            return this.data + "->" + this.next.printFoward();
        } else {
            return this.data;
        }
    }



    public String printNodes() {
        if (this.next != null) {
            return this.data + "->" + this.next.printNodes();
        } else {
            return this.data;
        }
    }











































}
