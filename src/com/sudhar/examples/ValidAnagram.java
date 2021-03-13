package com.sudhar.examples;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {

        if (s == null && t != null) {
            return false;
        }

        if (s != null && t == null) {
            return false;
        }

        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];

        for (int i = 0 ; i < s.length(); i++) {
            char c= s.charAt(i);
            count[c - 'a']++;
        }
        System.out.println(count);

        for (int i = 0 ; i < t.length(); i++) {
            char c= t.charAt(i);
            count[c - 'a']--;
        }

        System.out.println(count);
        for (int i = 0 ; i < 26; i++) {
            if (count[i] < 0) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        ValidAnagram va = new ValidAnagram();

        System.out.println(va.isAnagram("anagram", "nagaram"));
    }

}
