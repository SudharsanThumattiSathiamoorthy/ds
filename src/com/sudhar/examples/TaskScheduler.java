package com.sudhar.examples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskScheduler {

    public static void main(String[] args) {
        TaskScheduler ts = new TaskScheduler();

        System.out.println(ts.leastInterval(new char[] {'A', 'A', 'A', 'B', 'B', 'B'}, 2));
    }
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char c: tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);

        queue.addAll(map.values());

        int count = 0;

        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int k = n + 1;

            while (k > 0 && !queue.isEmpty()) {
                int no = queue.poll();
                k--;
                count++;
                list.add(no-1);
            }

            for (Integer no : list) {
                if (no > 0) {
                    queue.add(no);
                }
            }

            System.out.println(queue);
            if (!queue.isEmpty()) {
                count += k;
            }
        }

        return count;
    }

}
