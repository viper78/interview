package stack;

import java.util.Stack;

public class SimplifyPath {

    public static void main(String[] args) {

        String path = "/home/"; // expected "/home"
//        String path = "/a/./b/../../c/"; // expected "/c"

        SimplifyPath sp = new SimplifyPath();

        String s = sp.simplified(path);
        System.out.println(s);
    }

    private String simplified(String path) {

        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack();

        if (path == null || path.length() == 0)
            return sb.toString();

        String[] words = path.split("/");

        for (String p : words) {

            if (p.length() == 0 || p.equals(".")) {
              // Nothing
            } else if (p.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(p);
            }
        }

        if(stack.isEmpty()) {
            sb.append("/");
        } else {
            while (!stack.isEmpty()) {
                sb.insert(0, stack.pop());
                sb.insert(0, "/");
            }
        }

        return sb.toString();
    }
}
