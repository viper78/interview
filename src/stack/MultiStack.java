package stack;

/**
 * Created by rajeshsubramanian on 3/17/18.
 */
public class MultiStack {


    public static void main( String[] args ) {
        int numOfStacks = 3;
        int maxElements = 4;

        int[] stackSizes = new int[numOfStacks];
        int[] values = new int[numOfStacks * maxElements];

        MultiStack multiStack = new MultiStack();
        multiStack.push(1, 10, stackSizes, values);
        multiStack.push(1, 20, stackSizes, values);
        multiStack.push(3, 40, stackSizes, values);
        multiStack.push(1, 50, stackSizes, values);
        multiStack.push(2, 100, stackSizes, values);
        multiStack.push(2, 200, stackSizes, values);

        for (int i = 0; i < numOfStacks * maxElements; i++) {
            System.out.print(values[i] + " ");
        }

        multiStack.pop( 1, stackSizes, values );
        multiStack.pop( 3, stackSizes, values );
        multiStack.pop( 2, stackSizes, values );

        System.out.println("\n\n");
        for (int i = 0; i < numOfStacks * maxElements; i++) {
            System.out.print(values[i] + " ");
        }
    }

    private void push( int stackNum, int data, int[] stackSizes, int[] values ) {

        if (isStackFull(stackNum, stackSizes)) {
            return;
        }

        int offset = (stackNum -1) * 4;
        int existingCount = stackSizes[stackNum - 1];
        int totalOffset = offset + existingCount;

        values[totalOffset] = data;
        stackSizes[stackNum - 1]++;
    }

    private int pop( int stackNum, int[] stackSizes, int[] values ) {

        if (isStackEmpty(stackNum, stackSizes)) {
            return -1;
        }

        int offset = (stackNum -1) * 4;
        int existingCount = stackSizes[stackNum - 1];
        int totalOffset = offset + existingCount;

        stackSizes[stackNum - 1]--;
        int val = values[totalOffset-1];
        values[totalOffset-1] = 0;
        return val;
    }

    private boolean isStackEmpty( int stackNum, int[] stackSizes ) {

        if (stackSizes[stackNum - 1] == 0) {
            return true;
        }
        return false;
    }

    private boolean isStackFull( int stackNum, int[] stackSizes ) {

        if (stackSizes[stackNum -1] == 4) {
            return true;
        }
        return false;
    }
}
