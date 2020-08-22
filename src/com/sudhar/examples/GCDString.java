package com.sudhar.examples;

public class GCDString {

    public String gcdOfStrings(String str1, String str2) {
        String s = str1.length() < str2.length() ? str1 : str2;

        int len = s.length();

        for (int i = 1; i < len; i++) {
            if (len % i != 0) {
                continue;
            }

            String sub = s.substring(0, len / i);

            if (str1.replaceAll(sub, "").equals("") && str2.replaceAll(sub, "").equals("")) {
                return sub;
            }
        }

        return "";
    }

    // str1 = "ABCABC", str2 = "ABC"
    //Output: "ABC"

    // str1 = "ABABAB", str2 = "ABAB"
    // Output: "AB"

    // str1 = "LEET", str2 = "CODE"
    // Output: ""
}
