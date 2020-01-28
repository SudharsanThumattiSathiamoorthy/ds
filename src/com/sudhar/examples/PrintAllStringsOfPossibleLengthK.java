package com.sudhar.examples;

public class PrintAllStringsOfPossibleLengthK {

    public static void main(String[] args) {
        char[] a = {'a', 'b'};

        int k = 3;

        printAllStrings("", a, k);
    }


    private static void printAllStrings(String prefix, char[] a, int k) {
        if (k == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < a.length; i++) {
                String tempPrefix = prefix + a[i];

                printAllStrings(tempPrefix, a, k - 1);
            }
        }
    }
}
