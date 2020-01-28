package com.sudhar.examples;

public class RepeatedSubstringPattern {

    public static void main(final String[] args) {
        System.out.println(repeatedSubstringPattern("abcabcabc"));
    }

    public static boolean repeatedSubstringPattern(String str) {
        int l = str.length();
        for (int i = l / 2; i >= 1; i--) {
            if (l % i == 0) {
                int m = l / i;
                String subS = str.substring(0, i);
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < m; j++) {
                    sb.append(subS);
                }
                if (sb.toString().equals(str)){
                    System.out.println(str);
                    return true;
                }
            }
        }

        return false;
    }

}
