package stack;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidateParens {

    public static void main(String[] args) {

        String str = "[[]]{}()[";

        System.out.println(validateBraces(str));
    }
    public static boolean validateBraces(String str) {

        char[] arr = str.toCharArray();
        Map<Character, Character> map = new HashMap<>();
        map.put('[', ']');
        map.put('(', ')');
        map.put('{', '}');

        Stack<Character> stack = new Stack();

        for (int i = 0; i < arr.length; i++) {

            if (map.containsKey(arr[i])) {
                stack.push(arr[i]);
            } else if (!stack.isEmpty() && map.values().contains(arr[i])){
                if (map.get(stack.peek()).equals(arr[i])) {
                    stack.pop();
                }

            }
        }

        if (!stack.isEmpty()) return false;

        return true;
    }
}
