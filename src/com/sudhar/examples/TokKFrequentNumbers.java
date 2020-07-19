package com.sudhar.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TokKFrequentNumbers {

    public static void main(String[] args) {
        TokKFrequentNumbers top = new TokKFrequentNumbers();
        int[] nums = {1,1,1,2,2,3};

        System.out.println(top.topKFrequent(nums, 2));

    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0|| k == 0) {
            return null;
        }

        Map<Integer, Integer> map = new HashMap<>();

        Arrays.stream(nums).forEach(num -> {
            int count = map.getOrDefault(num, 0) ;
            map.put(num, count + 1);
        });

        PriorityQueue<Map.Entry<Integer, Integer>>
                queue = new PriorityQueue<>((e1, e2) -> e2.getValue() == e1.getValue() ? e1.getKey() - e2.getKey() : e2.getValue() - e1.getValue() );

        map.entrySet().forEach(entrySet -> {
            queue.add(entrySet);
        });

        List<Integer> result = new ArrayList<>();

        while(!queue.isEmpty() && k-- > 0) {
            Map.Entry<Integer, Integer> entrySet = queue.poll();
            result.add(entrySet.getKey());
        }

        return result;
    }
}
