package com.sudhar.examples;

public class RepeatedSubstringPattern {

    public static void main(final String[] args) {
        System.out.println(repeatedSubstringPattern("abab"));
    }

    public static boolean repeatedSubstringPattern(String s) {
        int l = s.length();
        for (int i = l / 2; i >= 1; i--) {
            if (l % i == 0) {
                int m = l / i;
                String subS = s.substring(0, i);
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < m; j++) {
                    sb.append(subS);
                }
                if (sb.toString().equals(s)){
                    System.out.println(s);
                    return true;
                }
            }
        }

        return false;
    }

}
