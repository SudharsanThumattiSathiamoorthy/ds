package com.sudhar.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Amplitude {

    // To find the minimum amplitude, either we remove the leftmost or rightmost number in nums. If we remove any number in the middle, the amplitude is not changed.
    // After removing k characters (either from left or right), there are still n-k items left.
    // All the possible subarrays are [nums[0], ..., nums[n-k-1] or [nums[1], ..., nums[n-k] or ... or [nums[k], ..., nums[n-1].
    // Use a for-loop to go through all possible subarrays.
    public static int minAmplitude2(int[] nums) {
        if(nums.length <= 4) return 0;
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>();
        PriorityQueue<Integer> minQueue = new PriorityQueue<>(Collections.reverseOrder());
        for(int n : nums) {
            maxQueue.add(n);
            if(maxQueue.size() > 4) maxQueue.poll();
            minQueue.add(n);
            if(minQueue.size() > 4) minQueue.poll();
        }
        List<Integer> maxList = new ArrayList<>();
        while(maxQueue.size() > 0) maxList.add(maxQueue.poll());
        List<Integer> minList = new ArrayList<>();
        while(minQueue.size() > 0) minList.add(minQueue.poll());
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i <= 3; i++) {
            ans = Math.min(ans, maxList.get(i) - minList.get(3-i));
        }
        return ans;
    }

}
