package com.sudhar.examples;

public class UniqueCharsInAString {

    public static void main(String[] args) {
        String s = "ilovecoding";

        System.out.println(isStrUnique(s));

        s = "abcdefghi";

        System.out.println(isStrUnique(s));
    }

    private static boolean isStrUnique(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }

        int check = 0;

        for (int i = 0; i < str.length(); i++) {
           int index = str.charAt(i) - 'a';

           if ((check & (1  << index)) > 0) {
               return false;
           }

           check |= (1 << index);
        }

        return true;
    }
}
