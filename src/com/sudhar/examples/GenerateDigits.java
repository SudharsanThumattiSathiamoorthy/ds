package com.sudhar.examples;

import java.util.Arrays;

public class GenerateDigits {

    public static void main(final String[] args) {
        int a[] = new int[3];
        generateDigits(a, 3);
    }

    private static void generateDigits(int[] a, int n) {
        if (n == 0) {
            System.out.println(Arrays.toString(a));
        } else {
            a[n-1] = 0;
            generateDigits(a, n-1);
            a[n-1] = 1;
            generateDigits(a, n-1);
        }
    }

    public static String substringAfterLast(String str, String separator) {
        if (isEmpty(str)) {
            return str;
        } else if (isEmpty(separator)) {
            return "";
        } else {
            int pos = str.lastIndexOf(separator);
            return pos != -1 && pos != str.length() - separator.length() ? str.substring(pos + separator.length()) : "";
        }
    }

    public static boolean isEmpty(CharSequence cs) {
        return cs == null || cs.length() == 0;
    }
}
