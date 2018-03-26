package com.sudhar.examples;

import java.util.Stack;

public class InfixToPostfix {
    public static void main(final String[] args) {
        final String ip = "a*b+c";

        convertInfixToPostfix(ip);
        System.out.println();
    }

    private static void convertInfixToPostfix(String ip) {

        final Stack<Character> stack = new Stack();

        for (int i= 0 ;i < ip.length(); i++) {
            if (isOperand(ip.charAt(i))) {
                System.out.print(ip.charAt(i));
                continue;
            }

            if (ip.charAt(i) == '(') {
                stack.push('(');
                continue;
            }

            if (ip.charAt(i) == ')') {
                while (stack.peek() != '(') {
                    System.out.print(stack.pop());
                }
                stack.pop();
                continue;
            }

            if (isOperator(ip.charAt(i))) {
                if (stack.isEmpty()) {
                    stack.push(ip.charAt(i));
                } else {
                    while(!stack.isEmpty() && precedence(stack.peek()) > precedence(ip.charAt(i))) {
                        System.out.print(stack.pop());
                    }
                    stack.push(ip.charAt(i));
                }
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }

    private static boolean isOperand(Character c) {
        return Character.isLetter(c);
    }

    private static boolean isOperator(Character c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }

    private static int precedence(Character c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
}
