package com.sudhar.examples;

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        // COUNT NUMBER OF WORDS TRANSFORMED
        int count = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            // FOR ALL WORDS THIS ROUND
            for (int i = 0; i < size; i++) {
                char[] current = queue.poll().toCharArray();
                // TRAVERSE CURRENT WORD
                for (int j = 0; j < current.length; j++) {
                    char tmp = current[j];
                    // CHANGE ONE LETTER AT A TIME
                    for (char c = 'a'; c <= 'z'; c++) {
                        current[j] = c;
                        String next = new String(current);
                        // WHEN NEXT WORD IS IN THE SET
                        if (set.contains(next)) {
                            if (next.equals(endWord)) return count + 1;
                            queue.add(next);
                            set.remove(next);
                        }
                    }
                    // HAVE TO UNDO FOR NEXT CHANGE OF LETTER
                    current[j] = tmp;
                }
            }
            // THIS ROUND ENDS WITH ONE LETTER CHANGED
            count++;
        }
        return 0;
    }


//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        Set<String> set = new HashSet<>(wordList);
//        if(!set.contains(endWord)) return 0;
//
//        Queue<String> queue = new LinkedList<>();
//        queue.add(beginWord);
//
//        Set<String> visited = new HashSet<>();
//        queue.add(beginWord);
//
//        int changes = 1;
//
//        while(!queue.isEmpty()){
//            int size = queue.size();
//            for(int i = 0; i < size; i++){
//                String word = queue.poll();
//                if(word.equals(endWord)) return changes;
//
//                for(int j = 0; j < word.length(); j++){
//                    for(int k = 'a'; k <= 'z'; k++){
//                        char arr[] = word.toCharArray();
//                        arr[j] = (char) k;
//
//                        String str = new String(arr);
//                        if(set.contains(str) && !visited.contains(str)){
//                            queue.add(str);
//                            visited.add(str);
//                        }
//                    }
//                }
//            }
//            ++changes;
//        }
//        return 0;
//    }

}
