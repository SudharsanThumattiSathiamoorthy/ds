package com.sudhar.examples;

public class MaxSumOfThreeSubArrays {

//    class Solution:
//    def maxSumOfThreeSubarrays(self, nums, k):
//            # try sliding window method
//    res = [0]*3 # store the final results
//
//    psum = [0]*(len(nums)+1)
//            for i in range(1, len(psum)):
//    psum[i] = psum[i-1] + nums[i-1] # compute prefix-sum
//
//            s1 = s12 = s123 = 0 # s1 = left k-numbers' sum; s12: left/mid 2k numbers' sum; s123: left/mid/right 3k numbers' sum
//    i11 = i21 = i22 = -1 # record three left-indices
//
//        # i is always for the left interval's left-most element's index
//        for i in range(0, len(nums)-3*k+1): # i from 0 is easy to understand, i's max value is i itself is the start of the final 3k elements, so, there are at least 3k-1 numbers at the right-hand-side of i: thus, len(nums) - (3k-1) = len(nums) - 3k+1 is the right-hand-side not-reachable boundary! (due to i starts from 0)
//            if s1 < psum[i+k] - psum[i]: # i.e., we find a larger left-interval
//            s1 = psum[i+k] - psum[i] # record this sum-up
//            i11 = i # (local) max left inverval's left-index
//
//            if s1+psum[i+2*k]-psum[i+k] > s12: # we find a larger left+mid interval (two intervals)
//    s12 = s1+psum[i+2*k]-psum[i+k] # record this sum-up
//            i21 = i11 # to yield max s12, max left interval's left-index
//    i22 = i + k # to yield max s12, max mid interval's left-index
//
//            if s12 + psum[i+3*k] - psum[i+2*k] > s123: # we find a larger left+mid+right interval (three intervals)
//    s123 = s12 + psum[i+3*k] - psum[i+2*k] # record this sum of three intervals! [for later updating of increasing i]
//    res = [i21, i22, i + 2*k] # i21 and i22 are from s12! only i+2*k here is for right interval's left-index!
//
//            # points: i will range over all possible values of the left-interval's left-most index;
//            # so, i+k will range over all the possible values of the middle-interval's left-most index;
//            # and, i+2k will range over all the possible values of the right-interval's left-most index.
//            return res

        public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
            int[] res = new int[3];
            int[] psum = new int[nums.length+1];
            for(int i=1; i<psum.length; i++){
                psum[i] += psum[i-1]+nums[i-1];
            }

            int s1 = 0, s12 = 0, s123 = 0;
            int i11 = -1, i21 = -1, i22 = -1;
            for(int i=0; i<=nums.length - 3*k; i++){         //start of 1st arr

                if(s1<psum[i+k] - psum[i]){
                    s1 = psum[i+k] - psum[i];
                    i11 = i;
                }

                if(s1+ psum[i+2*k] - psum[i+k] > s12){
                    s12 = s1 + psum[i+2*k] - psum[i+k];
                    i21 = i11;
                    i22 = i+k;
                }

                if(s12 + psum[i+3*k] - psum[i+2*k] > s123){
                    s123 = s12 + psum[i+3*k] - psum[i+2*k];
                    res[0] = i21;
                    res[1] = i22;
                    res[2] = i+2*k;
                }
            }
            return res;
        }

//    In a given array nums of positive integers, find three non-overlapping subarrays with maximum sum.
//
//    Each subarray will be of size k, and we want to maximize the sum of all 3*k entries.
//
//    Return the result as a list of indices representing the starting position of each interval (0-indexed). If there are multiple answers, return the lexicographically smallest one.
//
//    Example:
//
//    Input: [1,2,1,2,6,7,5,1], 2
//    Output: [0, 3, 5]
//    Explanation: Subarrays [1, 2], [2, 6], [7, 5] correspond to the starting indices [0, 3, 5].
//    We could have also taken [2, 1], but an answer of [1, 3, 5] would be lexicographically larger.
}
