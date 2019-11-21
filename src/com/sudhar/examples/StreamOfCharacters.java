package com.sudhar.examples;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class StreamOfCharacters {

    Trie1 root;
    Deque<Character> chars;
    int maxLen;

    public static void main(String[] args) {

    }

    StreamOfCharacters(String[] words) {
        root = new Trie1();
        chars = new LinkedList<>();

        for (String word: words) {
            root.addWord(new StringBuilder(word).reverse().toString());

            maxLen = Math.max(maxLen, word.length());
        }
    }

    boolean addChar(char c) {
        chars.addLast(c);

        if (chars.size() > maxLen) {
            chars.pollFirst();
        }

        Iterator<Character> iterator = chars.descendingIterator();
        return root.searchWord(iterator);
    }
}

class Trie1 {
   TrieNode root;

   Trie1() {
       root = new TrieNode();
   }

   void addWord(String word) {
       if (word == null || word.length() == 0) {
           return;
       }

       TrieNode curr = root;
       for (char c: word.toCharArray()) {
           int index = c - 'a';
           TrieNode next = curr.next[index];

           if (next == null) {
               next = new TrieNode();
               curr.next[index] = next;
           }

           curr = next;
       }

       curr.isWord = true;
   }

   boolean searchWord(Iterator<Character> iterator) {
       if (iterator == null || !iterator.hasNext()) {
           return false;
       }

       TrieNode curr = root;

       while (iterator.hasNext()) {
           char c = iterator.next();

           int index = c - 'a';

           TrieNode next = curr.next[index];

           if (next == null) {
               return false;
           }

           if (next.isWord) {
               return  true;
           }

           curr = next;
       }
       return false;
   }
}

class TrieNode {
    TrieNode[] next;
    boolean isWord;

    TrieNode() {
        this.next = new TrieNode[26];
        this.isWord = false;
    }
}