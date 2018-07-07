package stack;

import java.util.Stack;

public class NearestSmallestElement {

    public static void main(String[] args) {
        int arr[] = {1, 3, 0, 2, 5};

        nearestSmallestElement(arr);
    }

    private static void nearestSmallestElement(int[] arr) {

        if (arr.length == 0) return;

        Stack<Integer> stack = new Stack();

        for (int i = 0; i < arr.length; i++) {

            while(!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                System.out.print("_, ");
            } else {
                System.out.print(stack.pop() + ", ");
            }
            stack.push(arr[i]);
        }
    }
}
