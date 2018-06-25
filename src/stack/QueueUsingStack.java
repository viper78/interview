package stack;

import java.util.Stack;

/**
 * Created by rajeshsubramanian on 3/17/18.
 */
public class QueueUsingStack {

    public static void main( String[] args ) {
        MyQueue<Integer> myQueue = new MyQueue<>();
        myQueue.add( 10 );
        myQueue.add( 20 );
        myQueue.add( 30 );

        System.out.println(myQueue.get());
        System.out.println(myQueue.get());
        System.out.println(myQueue.get());

    }
}

class MyQueue<T> {
    private Stack<T> newStack;
    private Stack<T> oldStack;

    MyQueue() {
        newStack = new Stack<>();
        oldStack = new Stack<>();
    }
    public boolean add(T element) {
        newStack.push( element );
        return true;
    }

    public T get() {
        if (oldStack.isEmpty()) {
            while ( !newStack.isEmpty() ) {
                oldStack.push( newStack.pop() );
            }
        }
        return oldStack.pop();
    }
}
