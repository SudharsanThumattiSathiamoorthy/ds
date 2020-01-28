package com.sudhar.examples;

import java.util.*;

public class TopNBuzzWord {

    public static void main(String[] args) {

        TopNBuzzWord top = new TopNBuzzWord();
        String[] toys = {"elmo", "elsa", "legos", "drone", "tablet", "warcraft"};
        String[] quotes = {
                "Elmo is the hottest of the season! Elmo will be on every kid's wishlist!",
                "The new Elmo dolls are super high quality",
                "Expect the Elsa dolls to be very popular this year, Elsa!",
                "Elsa and Elmo are the toys I'll be buying for my kids, Elsa is good",
                "For parents of older kids, look into buying them a drone",
                "Warcraft is slowly rising in popularity ahead of the holiday season"
        };

        System.out.println(top.findTopBuzzWords(toys, quotes, 2));
    }

    public List<String> findTopBuzzWords(String[] toys, String[] quotes, int n) {
        if (toys == null || quotes == null) {
            return new ArrayList<>();
        }

        Set<String> toySet = new HashSet<>();
        for (String toy : toys) {
            toySet.add(toy);
        }

        Map<String, Integer> map = new HashMap<>();
        for (String temp : quotes) {
            String quote = temp.replaceAll("[\\',!]", "");

            for (String word : quote.split(" ")) {
                if (toySet.contains(word.toLowerCase())) {
                    int count = map.getOrDefault(word, 0);
                    map.put(word, count + 1);
                }
            }
        }

        PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String w1, String w2) {
                if (map.get(w1) == map.get(w2)) {
                    return w1.compareTo(w2);
                } else {
                    return Integer.compare(map.get(w1), map.get(w2));
                }
            }
        });

        List<String> result = new ArrayList<>();
        map.forEach((key, value) -> {
            queue.add(key);

            if (queue.size() > n) {
                queue.poll();
            }
        });

        while (!queue.isEmpty()) {
            result.add(queue.poll());
        }

        return result;
    }
}
