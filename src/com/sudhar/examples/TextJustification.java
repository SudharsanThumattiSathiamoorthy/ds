package com.sudhar.examples;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        if (res == null) {
            return res;
        }
        Deque<String> deque = new ArrayDeque<>();
        int lineLength = 0;
        int length = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            length = lineLength;
            if (lineLength > 0) {
                lineLength++;
            }
            lineLength += word.length();
            if (lineLength > maxWidth) {
                right = i - 1;
                flush(left, right, words, res, length, maxWidth);
                lineLength -= length + 1;
                left = i;
                right = i;
            }
        }
        right = words.length - 1;
        flush(left, right, words, res, length, maxWidth);

        return res;
    }

    private void flush(int left, int right, String[] words, List<String> res, int len, int max) {
        int extraSpaces = (right == words.length - 1) ? 0 : max - len;
        //+1 for the original space character between words
        int pad = (left != right) ? (extraSpaces / (right - left)) + 1 : 1;
        int remainingSpaces = (left != right) ? extraSpaces % (right - left) : 0;
        StringBuilder sb = new StringBuilder();
        for (int i = left; i <= right; i++) {
            sb.append(words[i]);
            if (i == right) {
                continue;
            }
            for (int j = 0; j < pad; j++) {
                sb.append(" ");
            }
            if (remainingSpaces > 0) {
                sb.append(" ");
                remainingSpaces--;
            }
        }
        while (sb.length() < max) {
            sb.append(" ");
        }
        res.add(sb.toString());
    }

    public static void main(String[] args) {
        TextJustification tj = new TextJustification();

        String[] w1 = {"This", "is", "an", "example", "of", "text", "justification."};
        System.out.println(tj.fullJustify(w1, 16));

        String[] w2 = {"What", "must", "be", "acknowledgment", "shall", "be"};
        System.out.println(tj.fullJustify(w2, 16));
    }

}
