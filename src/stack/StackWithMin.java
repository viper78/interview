package stack;

import java.util.Stack;

/**
 * Created by rajeshsubramanian on 3/17/18.
 */
public class StackWithMin  {

    public static void main( String[] args ) {
        MyStack myStack = new MyStack();
        myStack.push( 20 );
        myStack.push( 10 );
        myStack.push( 30 );
        myStack.push( 50 );

        System.out.println(myStack.peek().min);
    }

}

class MyStack extends Stack<NodeWithMin> {

    public NodeWithMin push(int value) {
        int min = Math.min( value, min() );
        NodeWithMin node = new NodeWithMin( value, min );
        return super.push( node );
    }

    private int min() {
        if (this.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return this.peek().min;
        }
    }

}

class NodeWithMin {
    int value;
    int min;

    NodeWithMin(int value, int min) {
        this.value = value;
        this.min = min;
    }
}

