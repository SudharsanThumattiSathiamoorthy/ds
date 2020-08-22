package com.sudhar.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoinPath {

        public List< Integer > cheapestJump(int[] A, int B) {
            int[] next = new int[A.length];
            Arrays.fill(next, -1);
            long[] memo = new long[A.length];
            jump(A, B, 0, next, memo);
            List < Integer > res = new ArrayList();
            int i;
            for (i = 0; i < A.length && next[i] > 0; i = next[i])
                res.add(i + 1);
            if (i == A.length - 1 && A[i] >= 0)
                res.add(A.length);
            else
                return new ArrayList < Integer > ();
            return res;
        }
        public long jump(int[] A, int B, int i, int[] next, long[] memo) {
            if (memo[i] > 0)
                return memo[i];
            if (i == A.length - 1 && A[i] >= 0)
                return A[i];
            long min_cost = Integer.MAX_VALUE;
            for (int j = i + 1; j <= i + B && j < A.length; j++) {
                if (A[j] >= 0) {
                    long cost = A[i] + jump(A, B, j, next, memo);
                    if (cost < min_cost) {
                        min_cost = cost;
                        next[i] = j;
                    }
                }
            }
            memo[i] = min_cost;
            return min_cost;
        }


        // Dynamic Programming.
    public class Solution {
        public List < Integer > cheapestJump(int[] A, int B) {
            int[] next = new int[A.length];
            long[] dp = new long[A.length];
            Arrays.fill(next, -1);
            List < Integer > res = new ArrayList();
            for (int i = A.length - 2; i >= 0; i--) {
                long min_cost = Integer.MAX_VALUE;
                for (int j = i + 1; j <= i + B && j < A.length; j++) {
                    if (A[j] >= 0) {
                        long cost = A[i] + dp[j];
                        if (cost < min_cost) {
                            min_cost = cost;
                            next[i] = j;
                        }
                    }
                }
                dp[i] = min_cost;
            }
            int i;
            for (i = 0; i < A.length && next[i] > 0; i = next[i])
                res.add(i + 1);
            if (i == A.length - 1 && A[i] >= 0)
                res.add(A.length);
            else
                return new ArrayList < Integer > ();
            return res;
        }
    }


}
//    Given an array A (index starts at 1) consisting of N integers: A1, A2, ..., AN and an integer B. The integer B denotes that from any place (suppose the index is i) in the array A, you can jump to any one of the place in the array A indexed i+1, i+2, …, i+B if this place can be jumped to. Also, if you step on the index i, you have to pay Ai coins. If Ai is -1, it means you can’t jump to the place indexed i in the array.
//
//        Now, you start from the place indexed 1 in the array A, and your aim is to reach the place indexed N using the minimum coins. You need to return the path of indexes (starting from 1 to N) in the array you should take to get to the place indexed N using minimum coins.
//
//        If there are multiple paths with the same cost, return the lexicographically smallest such path.
//
//        If it's not possible to reach the place indexed N then you need to return an empty array.


//Example 1:
//
//        Input: [1,2,4,-1,2], 2
//        Output: [1,3,5]
//
//
//        Example 2:
//
//        Input: [1,2,4,-1,2], 1
//        Output: []
