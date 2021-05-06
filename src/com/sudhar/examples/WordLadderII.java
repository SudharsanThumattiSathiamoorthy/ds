package com.sudhar.examples;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadderII {

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>();
        Set<String> used = new HashSet<>();

        Queue<LinkedList<String>> queue = new LinkedList<>();
        List<List<String>> result = new ArrayList<>();
        boolean found = false;

        for (String word : wordList) {
            words.add(word);
        }

        LinkedList<String> first = new LinkedList<>();
        first.add(beginWord);
        queue.offer(first);
        used.add(beginWord);

        while (!queue.isEmpty()) {
            int size = queue.size();
            HashSet<String> localUsed = new HashSet<>();
            while (size > 0) {
                LinkedList<String> curr = queue.poll();
                char[] word = curr.getLast().toCharArray();
                for (int i = 0; i < word.length; i++) {
                    char temp = word[i];
                    for (int j = 'a'; j <= 'z'; j++) {
                        word[i] = (char) j;
                        String s = String.valueOf(word);
                        if (!used.contains(s) && words.contains(s)) {
                            LinkedList<String> list = new LinkedList<>(curr);
                            list.add(s);
                            if (s.equals(endWord)) {
                                found = true;
                                result.add(list);
                                continue;
                            }
                            localUsed.add(s);
                            queue.offer(list);
                        }
                    }
                    word[i] = temp;
                }
                size--;
            }
            for (String s : localUsed) {
                used.add(s);
            }

            if (found) {
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(findLadders("hit", "cog", List.of("hot","dot","dog","lot","log","cog")));

        // System.out.println(findLadders("hit", "cog", List.of("hot","dot","dog","lot","log")));
    }
}
