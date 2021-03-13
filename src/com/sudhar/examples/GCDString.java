package com.sudhar.examples;

public class GCDString {

    public static String gcdOfStrings(String str1, String str2) {
        String s = str1.length() < str2.length() ? str1 : str2;

        int len = s.length();

        for (int i = 1; i < len; i++) {
            if (len % i == 1) {
                continue;
            }

            String sub = s.substring(0, len / i);
            System.out.println(i+ " " + sub);

            if (str1.replaceAll(sub, "").equals("") && str2.replaceAll(sub, "").equals("")) {
                return sub;
            }
        }

        return "";
    }

    public static void main(String[] args) {
       // gcdOfStrings("ABCABC", "ABC");
        gcdOfStrings("ABABAB", "ABAB");
    }

    // str1 = "ABCABC", str2 = "ABC"
    //Output: "ABC"

    // str1 = "ABABAB", str2 = "ABAB"
    // Output: "AB"

    // str1 = "LEET", str2 = "CODE"
    // Output: ""
}
