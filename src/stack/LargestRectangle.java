package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LargestRectangle {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(5);
        list.add(6);
        list.add(2);
        list.add(3);

        LargestRectangle lr = new LargestRectangle();
        System.out.println(lr.largestRectangleArea(list));
    }

    public int largestRectangleArea(List<Integer> input) {
        Stack<Integer> stack =new Stack<Integer>();
        int i = 0;
        int n = input.size();
        int top = 0;
        int currentArea = 0;
        int maxArea = 0;

        while(i < n){
            if(stack.empty() || input.get(i) >= input.get(stack.peek()))
                stack.push(i++);
            else {
                top =stack.pop();

                if (stack.isEmpty()) {
                    currentArea = input.get(top) * i;
                } else {
                    currentArea = input.get(top) * (i - stack.peek() - 1);
                }
                maxArea = Math.max(maxArea, currentArea);
            }
        }
        while(!stack.empty()){
            top=stack.pop();

            if (stack.isEmpty()) {
                currentArea = input.get(top) * i;
            } else {
                currentArea = input.get(top) * (i - stack.peek() - 1);
            }
            maxArea = Math.max(maxArea, currentArea);
        }
        return maxArea;
    }
}
