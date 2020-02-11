package com.sudhar.examples;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindPairWithTheGivenSum {

    public static void main(String[] args) {
        int[] a = {20, 50, 40, 25, 30, 10};

        System.out.println(Arrays.toString(findPairSum(a, 90 - 30)));

        System.out.println(Arrays.toString(findPairSum(new int[]{1, 2}, 90-30)));
    }

    private static int[] findPairSum(int[] nums, int target) {
        Map<Integer, Integer> index = new HashMap<>();
        int[] result = new int[] {-1, -1};

        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];

            if (index.containsKey(temp)) {
                int i1 = result[1] - result[0];
                int i2 = i - index.get(temp);
                if (i2 > i1) {
                    result[0] = index.get(temp);
                    result[1] = i;
                }
            }
            index.put(nums[i], i);
        }

        return result;
    }
}
