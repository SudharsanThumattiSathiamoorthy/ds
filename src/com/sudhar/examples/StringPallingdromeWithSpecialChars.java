package com.sudhar.examples;

public class StringPallingdromeWithSpecialChars {

    public static void main(final String[] args) {

        final String s = "a!@cbc&a";

        int l = 0, r = s.length() -1;
        boolean flag = false;

        while (l < r) {
            while(!Character.isLetter(s.charAt(l))) {
                l++;
            }

            while(!Character.isLetter(s.charAt(r))) {
                r--;
            }

            if (s.charAt(l) != s.charAt(r)) {
                flag = true;
                break;
            }
            l++;
            r--;
        }

        if (flag) {
            System.out.println("String is not pallingdrome");
        } else {
            System.out.println("String is pallingdrome");
        }
    }
}
