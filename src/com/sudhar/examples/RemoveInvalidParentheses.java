package com.sudhar.examples;

import java.util.*;

public class RemoveInvalidParentheses {

//    private boolean isParentheses(char c) {
//        return c == '(' || c == ')';
//    }
//
    private boolean isValidString(final String word) {
        int count = 0;

        if (word == null || word.length() == 0) {
            return true;
        }

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == '(') {
                count++;
            } else if (word.charAt(i) == ')') {
                count--;
            }
            if (count < 0) {
                return false;
            }
        }
        return count == 0;
    }
//
//    public void removeInvalidParentheses(final String word) {
//        if (word == null || word.length() == 0) {
//            return;
//        }
//
//        final Set<String> visited = new HashSet<>();
//        final Queue<String> queue = new LinkedList<>();
//
//        queue.add(word);
//        visited.add(word);
//
//        int done = -1;
//        while (!queue.isEmpty()) {
//            String temp = queue.poll();
//
//            if (temp.length() < done) {
//                break;
//            }
//
//            if (isValidString(temp)) {
//                System.out.println(temp);
//                done = temp.length();
//
//            } else {
//
//                for(int i = 0;i < temp.length(); i++) {
//                    if (!isParentheses(temp.charAt(i))) {
//                        continue;
//                    }
//
//                    String next = temp.substring(0, i) + temp.substring(i+1);
//
//                    if (!visited.contains(next)) {
//                        queue.add(next);
//                        visited.add(next);
//                    }
//                }
//
//            }
//        }
//    }

    public static void main(final String[] args) {

        RemoveInvalidParentheses rmi = new RemoveInvalidParentheses();
        rmi.removeInvalidParentheses("(a)())()");
    }

    private void removeInvalidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return;
        }

        int max = -1;
        Stack<String> visited = new Stack<>();
        Queue<String> queue = new LinkedList<>();

        queue.add(s);
        visited.add(s);

        while (!queue.isEmpty()) {

            final String curr = queue.poll();
            if (curr.length() < max) {
                break;
            }

            if (isValidParathesis(curr)) {
                System.out.println(curr);
                max = curr.length();
            } else {

                for (int i = 0; i < curr.length(); i++) {
                    if (!isParanthesis(curr.charAt(i))) {
                        continue;
                    }

                    String next = curr.substring(0, i) + curr.substring(i + 1);
                    if (!visited.contains(next)) {
                        queue.add(next);
                        visited.add(next);
                    }
                }
            }

        }

    }

    private boolean isParanthesis(char c) {
        return c == '(' || c == ')';
    }

    private boolean isValidParathesis(final String curr) {
        if (curr == null || curr.length() == 0) {
            return true;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < curr.length(); i++) {
            if (Character.isLetter(curr.charAt(i))) {
                continue;
            } else if (curr.charAt(i) == '(') {
                stack.push(curr.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char c = stack.pop();
                    if (c == ')') {
                        return false;
                    }
                }

            }
        }
        return stack.isEmpty();
    }

    //////////////////////////////////////////////////////////////////
    // Perfect solution - tested in leetcode
    //////////////////////////////////////////////////////////////////



//    class Solution {
//        public List<String> removeInvalidParentheses(String s) {
//            final List<String> emptyResult = new ArrayList<>();
//            emptyResult.add("");
//
//            if (s == null || s.length() == 0) {
//                return emptyResult;
//            }
//
//            final Queue<String> queue = new LinkedList<>();
//            final Set<String> visited = new HashSet<>();
//
//            queue.add(s);
//            int max = -1;
//            List<String> result = new ArrayList<>();
//
//            while(!queue.isEmpty()) {
//                final String temp = queue.poll();
//
//                //visited.add(temp);
//                if (temp.length() < max) {
//                    break;
//                }
//
//                if (!result.contains(temp) && isValidParathesis(temp)) {
//                    result.add(temp);
//                    max = temp.length();
//                } else {
//
//                    for(int i = 0;i < temp.length(); i++) {
//                        if (!isParanthesis(temp.charAt(i))) {
//                            continue;
//                        }
//
//                        String next = temp.substring(0, i) + temp.substring(i+1);
//
//                        if (!visited.contains(next)) {
//                            queue.add(next);
//                            visited.add(next);
//                        }
//                    }
//                }
//
//            }
//            return result.size() == 0 ? emptyResult : result;
//        }
//
//        private boolean isParanthesis(char c) {
//            return c == '(' || c == ')';
//        }
//
//        private boolean isValidParathesis(final String s) {
//            Stack<Character> stack = new Stack<>();
//
//            for (int i = 0; i < s.length(); i++) {
//                if (s.charAt(i) == '(') {
//                    stack.push(s.charAt(i));
//                }
//                else if (Character.isLetter(s.charAt(i))) {
//                    continue;
//                }
//                else {
//                    if (stack.isEmpty()) {
//                        return false;
//                    }
//
//                    Character c = stack.pop();
//                    if (c == null || c == ')') {
//                        return false;
//                    }
//                }
//            }
//            return stack.isEmpty();
//        }
//    }
}
