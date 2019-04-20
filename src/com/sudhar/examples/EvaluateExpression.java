package com.sudhar.examples;

import java.util.List;
import java.util.Stack;

public class EvaluateExpression {

    public static void main(final String[] args) {
        final List<String> input = List.of("5", "1", "2", "+", "4", "*", "+", "3", "-" );

        evaluateExpression(input);
    }

    private static int evaluateExpression(List<String> inputList) {
        int count = 0;

        final Stack<Integer> stack = new Stack<>();

        for (String input: inputList) {
            final char c = input.charAt(0);
            switch (c) {
                case '+':
                    count = add(stack.pop(), stack.pop());
                    stack.add(count);
                    break;
                case '-':
                    count = subtract(stack.pop(), stack.pop());
                    stack.add(count);
                    break;
                case '*':
                    count = multiply(stack.pop(), stack.pop());
                    stack.add(count);
                    break;
                case '/':
                    count = divide(stack.pop(), stack.pop());
                    stack.add(count);
                    break;
                default:
                    stack.add(Character.getNumericValue(c));
                    break;

            }
        }

        return stack.pop();
    }

    private static int divide(Integer n1, Integer n2) {
        return n1 / n2;
    }

    private static int multiply(Integer n1, Integer n2) {
        return n1 * n2;
    }

    private static int subtract(Integer n1, Integer n2) {
        return n1 - n2;
    }

    private static int add(Integer n1, Integer n2) {
        return n1 + n2;
    }
}
