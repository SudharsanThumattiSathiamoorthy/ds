package com.sudhar.examples;

public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        char[] chars = s.toCharArray();
        int count = 0, last  = 0;
        boolean flag = false;

        for (char c: chars) {
            if (c == ' ') {
                if (!flag) {
                    last = count;
                }

                count = 0;
                flag = true;
                continue;
            } else {
                flag = false;
                count++;
            }
        }
        return last;
    }

    public static void main(String[] args) {
        LengthOfLastWord lw = new LengthOfLastWord();

        System.out.println(lw.lengthOfLastWord("Hello World"));
    }

}
