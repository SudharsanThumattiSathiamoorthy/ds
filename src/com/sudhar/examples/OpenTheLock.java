package com.sudhar.examples;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// https://leetcode.com/problems/open-the-lock/
public class OpenTheLock {
        public int openLock(String[] deadends, String target) {
            Set<String> dead = new HashSet();
            for (String d: deadends) dead.add(d);

            Queue<String> queue = new LinkedList();
            queue.offer("0000");
           // queue.offer(null);

            Set<String> seen = new HashSet();
            seen.add("0000");

            int depth = 0;
            while (!queue.isEmpty()) {

                int size = queue.size();

                for (int k = 0; k < size; k++) {
                    String node = queue.poll();
                    //                if (node == null) {
                    //                    depth++;
                    //                    if (queue.peek() != null)
                    //                        queue.offer(null);
                    if (node.equals(target)) {
                        return depth;
                    } else if (!dead.contains(node) || !seen.contains(node)) {
                        for (int i = 0; i < 4; ++i) {
                            for (int d = -1; d <= 1; d += 2) {
                                int y = ((node.charAt(i) - '0') + d + 10) % 10;
                                String nei = node.substring(0, i) + ("" + y) + node.substring(i + 1);
                                if (!seen.contains(nei)) {
                                    seen.add(nei);
                                    queue.offer(nei);
                                }
                            }
                        }
                    }
                }
                depth++;
            }
            return -1;
        }

        public static void main(String[] args) {
            OpenTheLock otl = new OpenTheLock();
            System.out.println(otl.openLock(new String[]{"0201","0101","0102","1212","2002"}, "0202"));


            System.out.println(otl.openLock(new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"}, "8888"));
        }
}
