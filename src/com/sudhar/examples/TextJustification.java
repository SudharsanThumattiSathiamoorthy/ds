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

    //    List<String> result;
    //    /*
    //    The solution is divided into two parts:
    //    - First one is for counting the max number of words which can fit into one line, i.e. helper() function does
    //    it and also passes the next index to be traversed in the next turn.
    //    - Second part serve as a string editor, i.e. addToResult() uses the actual valid words lengths (len) and
    //    index of start and end (both inclusive) to count the spaces to be added.
    //        - A slight weird hanlding of lines which has only single word fitting or the last line. In both the cases,
    //        there would be bunch of spaces being inserted at the end. Also, for the last line, where would be only 1 space
    //        b/w words, instead of possible multiple spaces for other lines(due to the need for balancing).
    //     */
    //    public List<String> fullJustify(String[] words, int maxWidth) {
    //        result = new ArrayList<>();
    //        helper(words, maxWidth, 0);
    //        return result;
    //    }
    //
    //    private void helper(String[] words, int maxWidth, int start){
    //        if(start >= words.length) return;
    //        int totalWidth =0; // Includes the length of the words that can fit onto the line plus additional space b/w the words.
    //        int wordsWidth=0; // length of the words that fits onto the line w/o the extra spaces.
    //        int next = -1; // This is the index of the word that would start the next line.
    //        int i=start; // for iteration
    //        while(totalWidth < maxWidth && i < words.length) {
    //            totalWidth += words[i].length();
    //            if(totalWidth > maxWidth){
    //                next = i;
    //                break;
    //            }
    //            wordsWidth += words[i].length();
    //            totalWidth++; // Add space after adding the word.
    //            i++;
    //        }
    //        if(next == -1) // In case all the words fit onto the line and there isn't any break
    //            next = i;
    //        addToResult(words, maxWidth, start, next-1, wordsWidth);
    //        helper(words, maxWidth, next);
    //    }
    //
    //    private void addToResult(String[] words, int maxWidth, int start, int end, int wordsWidth){
    //        StringBuilder sb = new StringBuilder();
    //        int noOfPos = end-start; // Positions to insert space on each line = 1 less than number of words on each line cuz you need to ignore the last word.
    //        int spacesPerPos =(noOfPos == 0) ? 0 : (maxWidth - wordsWidth)/noOfPos;
    //        int moreSpaces = (noOfPos == 0) ? 0 : (maxWidth - wordsWidth)%noOfPos;
    //        boolean lastLine = false;
    //        if(noOfPos == 0 || end == words.length-1) // For the case of Last line(end = words.length-1)
    //        // or the line which only has 1 word noOfPos == 0, it needs to handled in a slightly different way.
    //        {
    //            lastLine = true;
    //            spacesPerPos = 1;
    //        }
    //        for(int k=start; k <= end; k++){
    //            sb.append(words[k]);
    //            if(k == end) break; // Do not add any space after the last word.
    //            for(int i=0 ; i < spacesPerPos; i++) // For last line, spacesPerPos value = 1 would take care to only add 1 space after each word.
    //                sb.append(" ");
    //            // Balancing space, and keeping the extra ones as left as possible.
    //            if (!lastLine && moreSpaces-- > 0)
    //                sb.append(" ");
    //        }
    //
    //        // If last line or only 1 word on that middle lines, add bunch of spaces at the end.
    //        if(lastLine){
    //            int spaceAtEnd = maxWidth-sb.length();
    //            for(int i=0; i < spaceAtEnd; i++)
    //                sb.append(" ");
    //        }
    //        result.add(sb.toString());
    //    }


}
