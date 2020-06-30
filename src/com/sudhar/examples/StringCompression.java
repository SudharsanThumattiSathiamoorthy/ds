package com.sudhar.examples;

public class StringCompression {

    public static void main(String[] args) {
        //System.out.println(compress(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'}));

        System.out.println(compressString1(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'}));
    }

    public static int compress(char[] chars) {
        int anchor = 0, write = 0;
        for (int read = 0; read < chars.length; read++) {
            if (read + 1 == chars.length || chars[read + 1] != chars[read]) {
                chars[write++] = chars[anchor];
                if (read > anchor) {
                    for (char c: ("" + (read - anchor + 1)).toCharArray()) {
                        chars[write++] = c;
                    }
                }
                anchor = read + 1;
            }
        }
        return write;
    }

    private static int compressString1(char[] word) {
        if (word == null || word.length == 0) {
            return 0;
        }

        int cWord = 0, index = 0;
        for (int i = 0; i < word.length; i++) {

            if (i +1  == word.length || word[i+1] != word[i]) {
                word[index++] = word[cWord];

                if (i > cWord) {
                    for (char c: ("" + (i - cWord + 1)).toCharArray()) {
                        word[index++] = c;
                    }
                }
                cWord = i + 1;
            }


        }

        return index;
    }
}
