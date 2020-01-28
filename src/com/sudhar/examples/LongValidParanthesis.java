package com.sudhar.examples;

public class LongValidParanthesis {

    public static void main(String[] args) {
        LongValidParanthesis lvp = new LongValidParanthesis();

        System.out.println(lvp.findLongestValidParanthesis(")()())"));
    }

    public int findLongestValidParanthesis(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int maxLength = Integer.MIN_VALUE;

        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right) {
                maxLength = Math.max(maxLength, left * 2);
            } else if (right >= left) {
                left = right = 0;
            }
        }

        left = 0; right = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                right++;
            } else {
                left++;
            }

            if (left == right) {
                maxLength = Math.max(maxLength, right * 2);
            } else if (left >= right){
                left = right = 0;
            }
        }

        return maxLength;
    }
}
