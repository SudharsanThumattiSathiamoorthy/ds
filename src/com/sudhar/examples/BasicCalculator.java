package com.sudhar.examples;

import java.util.Stack;

public class BasicCalculator {

//    public static int calculate(String s) {
//        int len = s.length(), sign = 1, result = 0;
//        Stack<Integer> stack = new Stack<>();
//
//        for (int i = 0; i < len; i++) {
//
//            if (Character.isDigit(s.charAt(i))) {
//                int sum = s.charAt(i) - '0';
//                while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
//                    sum = sum * 10 + s.charAt(i + 1) - '0';
//                    i++;
//                }
//                result += sum * sign;
//            } else if (s.charAt(i) == '+')
//                sign = 1;
//            else if (s.charAt(i) == '-')
//                sign = -1;
//            else if (s.charAt(i) == '(') {
//                stack.push(result);
//                stack.push(sign);
//                result = 0;
//                sign = 1;
//            } else if (s.charAt(i) == ')') {
//                result = result * stack.pop() + stack.pop();
//            }
//
//        }
//
//        return result;
//    }

    public static int calc(String s) {
        int sum = 0;

        final Stack<Integer> stack = new Stack<>();
        char sign = '+';

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                int val = 0;

                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    val = val * 10 + s.charAt(i) - '0';
                    i++;
                }

                i--;

                if (sign == '+') {
                    stack.push(val);

                } else if (sign == '-') {
                    stack.push(-val);

                } else if (sign == '*') {
                    int ans = stack.pop();
                    stack.push(ans * val);

                } else if (sign == '/') {
                    int ans = stack.pop();
                    stack.push(ans / val);
                }
            } else if (c != ' ') {
                sign = c;
            }
        }

        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        return sum;
    }

    public static void main(String[] args) {
//        System.out.println(calculate("(1+(4+5+2)-3)/(6+1)"));
//
      //  System.out.println(calc("14/7"));

       System.out.println(calc("(1+(4+5+2)-3)/(2+1)"));
    }
}
