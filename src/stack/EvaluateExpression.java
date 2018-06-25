package stack;


import java.util.Stack;

public class EvaluateExpression {
    // Amazon
    private final Stack<Integer> numStack = new Stack<Integer>();
    private final Stack<String> opStack = new Stack<String>();

    public int evaluate(String expression) {

        String[] tokens = expression.split("\\s+");

        for (int i = 0; i < tokens.length; i++) {

            if (tokens[i].matches("\\d+")) {
                numStack.push(Integer.parseInt(tokens[i]));
            } else {
                if (tokens[i].equals("(")) {
                    opStack.push(tokens[i]);
                } else if (tokens[i].equals(")")) {
                    while (!opStack.isEmpty() && !opStack.peek().equals("(")) {
                        numStack.push(compute(opStack.pop(), numStack.pop(), numStack.pop()));
                    }
                    opStack.pop();
                } else if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens.equals("/")) {
                    while (!opStack.isEmpty() && hasPrecedence(tokens[i], opStack.peek())) {
                        numStack.push(compute(opStack.pop(), numStack.pop(), numStack.pop()));
                    }
                    opStack.push(tokens[i]);
                }
            }
        }

        while (!opStack.isEmpty()) {
            numStack.push(compute(opStack.pop(), numStack.pop(), numStack.pop()));
        }

    return numStack.pop();

    }

    private int compute(String operator, Integer num2, Integer num1) {

        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num1 == 0) {
                    throw new UnsupportedOperationException("");
                }
                return num1/num2;
        }

        return 0;
    }

    private boolean hasPrecedence(String current, String top) {

        if ((current.equals("*") || current.equals("/")) && (top.equals("+") || top.equals("-"))) {
            return false;
        }
        if (top.equals("(") || top.equals(")")) {
            return false;
        }

        return true;
    }


    public static void main(String[] args) {

        EvaluateExpression expression = new EvaluateExpression();
        System.out.println(expression.evaluate("100 * ( 2 + 12 )"));
    }
}
