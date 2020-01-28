package com.sudhar.examples;

import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        SlidingWindowMaximum max = new SlidingWindowMaximum();

        System.out.println(Arrays.toString(max.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        if (nums.length == 1) {
            return nums;
        }

        int l = 0, r = 0, max = Integer.MIN_VALUE;

        Deque<Integer> queue = new LinkedList<>();

        while (r < k) {
            max = Math.max(max, nums[r]);
            queue.add(nums[r]);
            r++;
        }

        int[] result = new int[nums.length - k + 1];
        result[0] = max;

        for (; l < r && r  < nums.length; ) {
            queue.addLast(nums[r]);
            max = Math.max(max, nums[r]);
            r++;

            int removed = queue.pollFirst();
            if (removed ==  max) {
                max = findMax(queue);
            }
            l++;

            result[l] = max;
        }

        return result;
    }

    private Integer findMax(Deque<Integer> queue) {
        int max = Integer.MIN_VALUE;

        Iterator iterator = queue.iterator();

        while (iterator.hasNext()) {
            max = Math.max(max, (int) iterator.next());
        }
        return max;
    }
}
