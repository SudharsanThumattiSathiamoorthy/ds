package com.sudhar.examples;

public class ValidAlienDictionary {

    public static void main(String[] args) {

        String[] words = {"hello","leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";

        ValidAlienDictionary vad = new ValidAlienDictionary();
        System.out.println(vad.isValid(words, order));

        String[] w1 = {"word","world","row"};
        String o1 = "worldabcefghijkmnpqstuvxyz";
        System.out.println(vad.isValid(w1, o1));

        String[] w2 = {"apple","app"};
        String o2 = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(vad.isValid(w2, o2));

    }

    private boolean isValid(String[] words, String order) {
        if (words == null || words.length == 0 || order == null || order.length() == 0) {
            return false;
        }

        int[] index = new int[26];

        for (int i = 0; i < order.length(); i++) {
            index[order.charAt(i) - 'a'] = i;
        }

        search:for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i+1];

            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    if (index[word1.charAt(j) - 'a'] > index[word2.charAt(j) - 'a']) {
                        return false;
                    }
                    continue search;
                }
            }

            if (word1.length() > word2.length()) {
                return false;
            }
         }
        return true;
    }
}
