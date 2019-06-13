package com.sudhar.examples;

import java.util.ArrayList;
import java.util.List;

public class StringPermutation {

    public static void main(final String[] args) {
        String s = "abc";

        permute(s, "", 0);
    }

    private static void permute(String s, String prefix, int ci) {
        System.out.println(prefix);

        for (int i = ci; i < s.length(); i++) {
            String tempPrefix = prefix + s.charAt(i);
            String tempStr = s.substring(0, i) + s.substring(i+1);

            permute(tempStr, tempPrefix, i);
        }
    }

//    private static void permuate(final String prefix, final String input, final List<String> words, int currPosition) {
//        //if (input.length() == 0) {
//            System.out.println(prefix);
//            words.add(prefix);
//       // }
//
//            for (int i =currPosition; i < input.length(); i++) {
//                permuate(prefix + input.charAt(i), input.substring(0, i) + input.substring(i+1, input.length()), words, i);
//            }
//    }
}
