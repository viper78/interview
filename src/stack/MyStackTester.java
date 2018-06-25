package stack;

import java.util.NoSuchElementException;

public class MyStackTester {
}


interface IStack<T> {

    public void push(T ele);

    public T pop();
}

class StackImpl<T> implements IStack<T> {

    int capacity;
    Node head;

    @Override
    public void push(T ele) {

        Node first = head;
        first = new Node(ele);
        first.next = head;
        head = first;
        capacity++;
    }

    @Override
    public T pop() {

       if (head == null) throw new NoSuchElementException();

       T ele = (T) head.data;
       head = head.next;
        capacity--;
       return ele;
    }
}

class Node<T> {

    T data;
    Node next;

    Node(T data) {
        this.data = data;
    }
}