package com.sudhar.examples;

import java.util.*;

class Word {
    char[] words;
    int length;

    public Word(char[] words, int length) {
        this.words = words;
        this.length = length;
    }

    public char[] getWords() {
        return words;
    }

    public int getLength() {
        return length;
    }
}
public class MaxWordProduct {

    public static void main(final String[] args) {
        String[] input = {"cat", "dog", "feed", "pull", "space"};

        Map<String,Word> map = new HashMap<>();

        int max = 1;

        for (String ip: input) {
            int len = ip.length();
            char[] sorted = ip.toCharArray();

            Arrays.sort(sorted);

            for (Map.Entry<String, Word> entrySet: map.entrySet()) {
                if (isCommonCharsPresent(sorted, entrySet.getValue().getWords())) {
                    continue;
                }
                int temp = entrySet.getValue().getLength() * len;

                max = Math.max(temp, max);
            }
            map.put(ip, new Word(sorted, len));
        }

        System.out.println("Max : " + max);
    }

    private static boolean isCommonCharsPresent(char[] sorted, char[] words) {
        int len1 = sorted.length;
        int len2 = words.length;

        if (len1 < len2) {
            return isCommonCharsPresent(sorted, words, len1, len2);
        }
        return isCommonCharsPresent(words, sorted, len2, len1);
    }

    private static boolean isCommonCharsPresent(char[] a, char[] b, int l1, int l2) {
        for (int i=0, j=0; i != l1 && j != l2;) {
            if (a[i] == b[j]) {
                return true;
            }
            if (a[i] < b[j]) {
                i++;
            } else {
                j++;
            }
        }
        return false;
    }
}
