package com.sudhar.examples;

import java.util.Stack;

// Infix to postfix conversion.
public class DecodeString {

    public static void main(String[] args) {
        DecodeString ds = new DecodeString();

//                System.out.println(ds.decodeString("3[a]2[bc]"));
//        System.out.println(ds.decodeString("3[a2[c]]"));
//                System.out.println(ds.decodeString("2[abc]3[cd]ef"));
//                System.out.println(ds.decodeString("abc3[cd]xyz"));
//
//               System.out.println(ds.decodeString("3[a]2[bc]").equals("aaabcbc"));
//        System.out.println(ds.decodeString("3[a2[c]]").equals("accaccacc"));
//                System.out.println(ds.decodeString("2[abc]3[cd]ef").equals("abcabccdcdcdef"));
//                System.out.println(ds.decodeString("abc3[cd]xyz").equals("abccdcdcdxyz"));

        System.out.println(ds.decodeString( "100[leetcode]"));
    }

    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '[') {
                stack.add("" + c);
            } else if (Character.isDigit(c)) {
                stack.add("" + c);
            } else if (Character.isAlphabetic(c)) {
                stack.add("" + c);
            } else if (c == ']') {
                String temp = getEnclosedString(stack);
                stack.pop();
                // result.append(replicate(temp, stack.pop().toCharArray()[0] - '0'));
                stack.add(replicate(temp, Integer.parseInt(getNumbers(stack))));
            }
        }

        return getEnclosedString(stack);
    }

    private String getEnclosedString(Stack<String> stack) {
        String temp = "";
        while (!stack.isEmpty() && !stack.peek().equals("[")) {
            String pop = stack.pop() + temp;
            temp = pop;
        }

        return temp;
    }

    private String getNumbers(Stack<String> stack) {
        String temp = "";
        while (!stack.isEmpty() && !stack.peek().equals("[") && Character.isDigit(stack.peek().toCharArray()[0])) {
            String pop = stack.pop() + temp;
            temp = pop;
        }

        return temp;
    }

    private String replicate(String str, int no) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < no; i++) {
            sb.append(str);
        }

        return sb.toString();
    }
}
