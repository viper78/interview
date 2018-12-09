package stack;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class ScoreParanthesis {

    public static void main(String[] args) {

//        System.out.println(scoreOfParentheses("(()(()))"));


    List<String> list = Arrays.asList("one", "two", "three");

    String output = list.stream().reduce((x, y) -> x +"," + y).get();
        System.out.println(output);

    }


    public static int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack();
        stack.push(0); // The score of the current frame

        for (char c: S.toCharArray()) {
            if (c == '(')
                stack.push(0);
            else {
                int v = stack.pop();
                int w = stack.pop();
                stack.push(w + Math.max(2 * v, 1));
            }
        }

        return stack.pop();
    }
}
