package com.sudhar.examples;

import java.util.ArrayList;
import java.util.List;

public class StringPermutation {

    public static void main(final String[] args) {
        final List<String> words = new ArrayList<>();
        permuate("", "abc", words, 0);
        System.out.println(words.size());
    }

    private static void permuate(final String prefix, final String input, final List<String> words, int currPosition) {
        //if (input.length() == 0) {
            System.out.println(prefix);
            words.add(prefix);
       // }

            for (int i =currPosition; i < input.length(); i++) {
                permuate(prefix + input.charAt(i), input.substring(0, i) + input.substring(i+1, input.length()), words, i);
            }
    }
}
