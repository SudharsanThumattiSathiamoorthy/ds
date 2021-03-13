package com.sudhar.examples;

public class LicenseKeyFormatting {

    public static String licenseKeyFormatting(String S, int k) {
        StringBuilder sb =new StringBuilder();
        int count = 0;
        String s = S.toUpperCase();

        for(int i = s.length() - 1; i>= 0; i--) {

            char ch = s.charAt(i);
            if(ch != '-') {
                if(count == k) {
                    sb.append("-");
                    count = 0;
                    sb.append(ch);
                }
                else
                    sb.append(ch);
                count++;
            }

        }
        return sb.reverse().toString();
    }

    public static void main(String... args) {
        LicenseKeyFormatting.licenseKeyFormatting("5F3Z-2e-9-w", 4);
    }
}
