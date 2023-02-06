package codesignal;

import java.util.Stack;

public class ArraySwapAtmostOnePair {

    boolean solution(int[] a, int[] b) {

        if (a.length != b.length) return false;
        Stack<Integer> indexStack = new Stack<>();
        int diff = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                if (indexStack.isEmpty()) {
                    indexStack.push(i);
                    diff++;
                } else if (a[i] == b[indexStack.peek()] && b[i] == a[indexStack.peek()]) {
                    indexStack.pop();
                }
            }
            if (diff >= 2) return false;
        }

        return indexStack.empty();
    }
}
