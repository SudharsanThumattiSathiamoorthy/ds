package com.sudhar.examples;

import java.util.Map;

public class AllCombinationFromKeyPad {

    private static final Map<Integer, String> MAP = Map.of(0,"", 1, "", 2, "abc", 3, "def",
                                                           4, "ghi", 5, "jkl",
                                                           6, "mno", 7, "pqrs", 8, "tuv", 9, "wxyz");
    public static void main(String[] args) {

        findAllCombination("23", 0, new StringBuilder());

    }

    public static void findAllCombination(String phoneNo, int currentIndex, StringBuilder intermediateResult) {
        if (phoneNo.length() == currentIndex) {
            System.out.println(intermediateResult.toString());
        }
        else {
            String curr = MAP.get(phoneNo.charAt(currentIndex) - '0');
            for (int i = 0; i < curr.length(); i++) {
                intermediateResult.append(curr.charAt(i));
                findAllCombination(phoneNo, currentIndex + 1, intermediateResult);

                intermediateResult.deleteCharAt(intermediateResult.length() - 1);
            }
        }
    }
}
