package com.sudhar.examples;

public class LongPressedString {

    public static void main(String[] args) {
//        System.out.println(isLongPressedName("alex",
//                "aaleex"));
//
//        System.out.println(isLongPressedName("leelee",
//                "lleeelee"));

        System.out.println(isLongPressedName("vtkgn",
                "vttkgnn"));
    }

    public static boolean isLongPressedName(String name, String typed) {

        if (name == null || typed == null) {
            return false;
        }

        char[] s1 = name.toCharArray();
        char[] s2 = typed.toCharArray();

        char prev = s1[0];
        int i = 0, j = 0;

        while (i < s1.length && j < s2.length) {
            if (s1[i] == s2[j]) {
                prev = s1[i];
                i++;
                j++;
            } else if (prev == s2[j]) {
                j++;
            } else {
                return false;
            }
        }

        return (i == s1.length);
    }
}
