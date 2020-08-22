package com.sudhar.examples;

import java.util.TreeSet;

public class KEmptySlots {

//    You have N bulbs in a row numbered from 1 to N. Initially, all the bulbs are turned off. We turn on exactly one bulb everyday until all bulbs are on after N days.
//
//    You are given an array bulbs of length N where bulbs[i] = x means that on the (i+1)th day, we will turn on the bulb at position x where i is 0-indexed and x is 1-indexed.
//
//    Given an integer K, find out the minimum day number such that there exists two turned on bulbs that have exactly K bulbs between them that are all turned off.
//
//    If there isn't such day, return -1.
//
//
//
//    Example 1:
//
//    Input:
//    bulbs: [1,3,2]
//    K: 1
//    Output: 2
//    Explanation:
//    On the first day: bulbs[0] = 1, first bulb is turned on: [1,0,0]
//    On the second day: bulbs[1] = 3, third bulb is turned on: [1,0,1]
//    On the third day: bulbs[2] = 2, second bulb is turned on: [1,1,1]
//    We return 2 because on the second day, there were two on bulbs with one off bulb between them.
//            Example 2:
//
//    Input:
//    bulbs: [1,2,3]
//    K: 1
//    Output: -1
//
//
//    Note:
//
//            1 <= N <= 20000
//            1 <= bulbs[i] <= N
//    bulbs is a permutation of numbers from 1 to N.
//            0 <= K <= 20000
//

    class Solution1 {
        public int kEmptySlots(int[] flowers, int k) {
            TreeSet<Integer> active = new TreeSet();
            int day = 0;
            for (int flower: flowers) {
                day++;
                active.add(flower);
                Integer lower = active.lower(flower);
                Integer higher = active.higher(flower);
                if (lower != null && flower - lower - 1 == k ||
                    higher != null && higher - flower - 1 == k)
                    return day;
            }
            return -1;
        }
    }

//    Algorithm
//
//    As in Approach #2, we construct days.
//
//            Then, for each interval [left, right] (starting with the first available one), we'll check whether it is a candidate: whether days[i] > days[left] and days[i] > days[right] for left < i < right.
//
//    If we fail, then we've found some new minimum days[i] and we should check the new interval [i, i+k+1]. If we succeed, then it's a candidate answer, and we'll check the new interval [right, right+k+1].

    class Solution {
        public int kEmptySlots(int[] flowers, int k) {
            int[] days = new int[flowers.length];
            for (int i = 0; i < flowers.length; i++) {
                days[flowers[i] - 1] = i + 1;
            }

            int ans = Integer.MAX_VALUE;
            int left = 0, right = k+1;

            search: while (right < days.length) {
                for (int i = left+1; i < right; ++i) {
                    if (days[i] < days[left] || days[i] < days[right]) {
                        left = i;
                        right = i + k + 1;
                        continue search;
                    }
                }
                ans = Math.min(ans, Math.max(days[left], days[right]));
                left = right;
                right = left + k + 1;
            }

            return ans < Integer.MAX_VALUE ? ans : -1;
        }
    }
}
