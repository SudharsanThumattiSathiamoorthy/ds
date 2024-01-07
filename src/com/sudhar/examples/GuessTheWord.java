package com.sudhar.examples;

// https://leetcode.com/problems/guess-the-word/solutions/

//        You are given an array of unique strings words where words[i] is six letters long. One word of words was chosen as a secret word.
//
//        You are also given the helper object Master. You may call Master.guess(word) where word is a six-letter-long string, and it must be from words. Master.guess(word) returns:
//
//        -1 if word is not from words, or
//        an integer representing the number of exact matches (value and position) of your guess to the secret word.
//        There is a parameter allowedGuesses for each test case where allowedGuesses is the maximum number of times you can call Master.guess(word).
//
//        For each test case, you should call Master.guess with the secret word without exceeding the maximum number of allowed guesses. You will get:
//
//        "Either you took too many guesses, or you did not find the secret word." if you called Master.guess more than allowedGuesses times or if you did not call Master.guess with the secret word, or
//        "You guessed the secret word correctly." if you called Master.guess with the secret word with the number of calls to Master.guess less than or equal to allowedGuesses.
//        The test cases are generated such that you can guess the secret word with a reasonable strategy (other than using the bruteforce method).


import java.util.Collections;
import java.util.LinkedList;

public class GuessTheWord {

    public int countDiff(String a, String b) {
        int count = 0;
        for (int i = 0; i < 6; i++) {
            if (a.charAt(i) == b.charAt(i)) count++;
        }
        return count;
    }

    public void findSecretWord(String[] wordlist, Master master) {
        final LinkedList<Integer> left = new LinkedList<>();
        for (int i = 0; i < wordlist.length; i++) {
            left.offer(i);
        }

        while (true) {
            if (left.isEmpty()) {
                break;
            }

            Collections.shuffle(left);
            int current = left.poll();
            int diff = master.guess(wordlist[current]);
            int size = left.size();
            for (int j = 0; j < size; j++) {
                int next = left.poll();
                if (countDiff(wordlist[current], wordlist[next]) == diff) left.offer(next);
            }
        }
    }
}
