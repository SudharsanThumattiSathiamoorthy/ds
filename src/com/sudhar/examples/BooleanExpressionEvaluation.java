package com.sudhar.examples;

// https://leetcode.com/problems/parsing-a-boolean-expression/

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class BooleanExpressionEvaluation {

    public static void main(String[] args) {

        BooleanExpressionEvaluation b = new BooleanExpressionEvaluation();

        System.out.println(b.parseBoolExpr("|(&(t,f,t),!(t))"));
    }

    public boolean parseBoolExpr(String expression) {
        if (expression == null || expression.length() == 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        char[] exp = expression.toCharArray();

        for (int i = 0; i < exp.length; i++) {

            if (exp[i] == ')') {

                Set<Character> seen = new HashSet<>();
                while (!stack.isEmpty() && stack.peek() != '(') {
                    seen.add(stack.pop());
                }

                // to remove '('.
                stack.pop();

                char operator = stack.pop();

                if (operator == '&') {
                    stack.push(seen.contains('f') ? 'f' : 't');
                } else if (operator == '|') {
                    stack.push(seen.contains('t') ? 't' : 'f');
                } else {
                    stack.push(seen.contains('t') ? 'f' : 't');
                }
            } else if (exp[i] != ',') {
                stack.push(exp[i]);
            }
        }

        return stack.peek() == 't';
    }
}
