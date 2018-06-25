package stack;

import java.util.Stack;

/**
 * Created by rajeshsubramanian on 3/17/18.
 */
public class SortStack {

    public static void main( String[] args ) {
        Stack<Integer> old = new Stack<>();
        old.push( 5 );
        old.push( 7 );
        old.push( 2 );
        old.push( 1 );
        old.push( 8 );

        Stack newStack = sortStack(old);
        while ( !newStack.isEmpty() ) {
            System.out.println(newStack.pop());
        }
    }

    private static Stack sortStack( Stack<Integer> old ) {
        Stack<Integer> newStack = new Stack<>();
        while (!old.isEmpty()) {
            int tmp = old.pop();
            while ( !newStack.isEmpty() && newStack.peek() > tmp ) {
                old.push( newStack.pop() );
            }
            newStack.push( tmp );
        }
        return newStack;
    }

}
