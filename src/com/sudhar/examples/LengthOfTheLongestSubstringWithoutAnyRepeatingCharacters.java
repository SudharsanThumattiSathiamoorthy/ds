package com.sudhar.examples;

import java.util.HashSet;
import java.util.Set;

public class LengthOfTheLongestSubstringWithoutAnyRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        final Set<Character> uniqueChars = new HashSet<>();

        int startIndex = 0, endIndex = 0, maxLen = 0;
        char[] word = s.toCharArray();

        while (endIndex < word.length) {
            if (!uniqueChars.contains(word[endIndex])) {
                uniqueChars.add(word[endIndex]);
                endIndex++;
                maxLen = Math.max(maxLen, uniqueChars.size());
            } else {
                uniqueChars.remove(word[startIndex]);
                startIndex++;
            }
        }

        return maxLen;
    }
}
