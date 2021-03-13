package com.sudhar.examples;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class ReorganizeString {
    public String reorganizeString(String s) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> freq = new HashMap<>();
        for(char ch : s.toCharArray())
            freq.put(ch, freq.getOrDefault(ch, 0)+1);

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>(){
            public int compare(Map.Entry<Character, Integer> e1, Map.Entry<Character, Integer> e2){
                return e2.getValue()-e1.getValue();
            }
        });

        pq.addAll(freq.entrySet());
        Queue<Map.Entry<Character, Integer>> blacklist = new LinkedList<>();
        while(!pq.isEmpty()){
            int k=2; //cooling_period+1
            while(k > 0 && !pq.isEmpty()){
                Map.Entry<Character, Integer> e = pq.remove();
                e.setValue(e.getValue()-1);
                sb.append(e.getKey());
                blacklist.add(e);
                --k; //first item in the blacklist will wait for cooling_period units and then gets released
            }
            while(!blacklist.isEmpty()){
                Map.Entry<Character, Integer> e = blacklist.remove();
                if(e.getValue() > 0)
                    pq.add(e);
            }
            if(pq.isEmpty()) break;
            if(k > 0) return ""; //if idle slots allowed, we need k slots here
        }
        return sb.toString();
    }

    class MySolution {
        public String reorganizeString(String s) {

            if (s == null || s.length() == 0) {
                return "";
            }

            Map<Character, Integer> map = new HashMap<>();

            for (char c: s.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            StringBuffer sb = new StringBuffer();

            PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());

            queue.addAll(map.entrySet());


            Queue<Map.Entry<Character, Integer>> blackList = new LinkedList<>();

            while(!queue.isEmpty()) {
                int k = 2;

                while (k > 0 && !queue.isEmpty()) {
                    Map.Entry<Character, Integer> entry = queue.poll();
                    entry.setValue(entry.getValue() - 1);
                    blackList.add(entry);
                    sb.append(entry.getKey());
                    k--;
                }

                while (!blackList.isEmpty()) {
                    Map.Entry<Character, Integer> entry = blackList.poll();

                    if (entry.getValue() > 0) {
                        queue.add(entry);
                    }
                }

                if (queue.isEmpty()) {
                    break;
                }

                if (k > 0) {
                    return "";
                }
            }

            return sb.toString();
        }
    }
}
