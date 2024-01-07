package com.sudhar.examples;

public class ValidWordAbbreviation {

    public boolean validWordAbbreviation(String word, String abbr) {
        if (word.isEmpty()) {
            return abbr.isEmpty();
        }

        int wordLen = 0;
        int abbrLen = 0;

        while (wordLen < word.length() && abbrLen < abbr.length()) {
            if (!Character.isDigit(abbr.charAt(abbrLen))) {
                if (word.charAt(wordLen) == abbr.charAt(abbrLen)) {
                    wordLen++;
                    abbrLen++;
                } else {
                    return false;
                }
            } else {
                // edge case: leading zero
                if (abbr.charAt(abbrLen) == '0') {
                    return false;
                }

                int num = 0;
                while (abbrLen < abbr.length() && Character.isDigit(abbr.charAt(abbrLen))) {
                    int digit = Character.getNumericValue(abbr.charAt(abbrLen));
                    num = num * 10 + digit;
                    abbrLen++;
                }

                wordLen += num;
            }
        }

        return wordLen == word.length() && abbrLen == abbr.length();
    }

    public static void main(String[] args) {
        ValidWordAbbreviation validWordAbbreviation = new ValidWordAbbreviation();
        System.out.println(validWordAbbreviation.validWordAbbreviation("internationalization", "i12iz4n"));
        System.out.println(validWordAbbreviation.validWordAbbreviation("apple", "a2e"));
    }
}
