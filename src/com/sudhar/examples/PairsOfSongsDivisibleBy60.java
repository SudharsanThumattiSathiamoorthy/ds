package com.sudhar.examples;

import java.util.HashMap;
import java.util.Map;

public class PairsOfSongsDivisibleBy60 {

    // (a + b) % 60 => ((a % 60) + (b % 60)) % 60 = 0

    public int noOfParisDivisbileBy60(final int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int no : nums) {
            if (no % 60 == 0) {
                count += map.getOrDefault(0, 0);
            } else {
                count += map.getOrDefault(60 - no % 60, 0);
            }

            int cnt = map.getOrDefault(no % 60, 0);
            map.put(no % 60, cnt + 1);
        }

        return count;
    }


    public static void main(String[] args) {
        // https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/

        //        Input: time = [30,20,150,100,40]
        //        Output: 3
        //        Explanation: Three pairs have a total duration divisible by 60:
        //        (time[0] = 30, time[2] = 150): total duration 180
        //        (time[1] = 20, time[3] = 100): total duration 120
        //        (time[1] = 20, time[4] = 40): total duration 60

        PairsOfSongsDivisibleBy60 pair = new PairsOfSongsDivisibleBy60();

        assert pair.noOfParisDivisbileBy60(new int[] {30,20,150,100,40}) == 3;
    }

}
