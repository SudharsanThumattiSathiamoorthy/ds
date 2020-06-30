package com.sudhar.examples;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    public static void main(String[] args) {

        SubarraySumEqualsK s = new SubarraySumEqualsK();

        System.out.println(s.subarraySum(new int[] {1, 0, 1, 2, -1}, 2));
    }

    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        Map<Integer, Integer> map = new HashMap<>();

        int count = 0, currSum = 0;

        for (int n: nums) {
            currSum += n;

            if (currSum == k) {
                count++;
            }

            if (map.get(currSum - k) != null) {
                count += map.get(currSum - k);
            }

            if (map.get(currSum) == null) {
                map.put(currSum, 1);
            } else {
                int c = map.get(currSum);
                map.put(currSum, c + 1);
            }
        }
        return count;
    }
}
