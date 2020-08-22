package com.sudhar.examples;

public class DivideChocolate {
//
//    You have one chocolate bar that consists of some chunks. Each chunk has its own sweetness given by the array sweetness.
//
//    You want to share the chocolate with your K friends so you start cutting the chocolate bar into K+1 pieces using K cuts, each piece consists of some consecutive chunks.
//
//    Being generous, you will eat the piece with the minimum total sweetness and give the other pieces to your friends.
//
//    Find the maximum total sweetness of the piece you can get by cutting the chocolate bar optimally.
//
//
//
//            Example 1:
//
//    Input: sweetness = [1,2,3,4,5,6,7,8,9], K = 5
//    Output: 6
//    Explanation: You can divide the chocolate to [1,2,3], [4,5], [6], [7], [8], [9]
//    Example 2:
//
//    Input: sweetness = [5,6,7,8,9,1,2,3,4], K = 8
//    Output: 1
//    Explanation: There is only one way to cut the bar into 9 pieces.
//            Example 3:
//
//    Input: sweetness = [1,2,2,1,2,2,1,2,2], K = 2
//    Output: 5
//    Explanation: You can divide the chocolate to [1,2,2], [1,2,2], [1,2,2]

    class Solution {
        public int maximizeSweetness(int[] sweetness, int K) {
            if (sweetness == null || sweetness.length<K+1) return 0;
            int sum = 0;
            for (int i=0; i<sweetness.length; i++) {
                sum+=sweetness[i];
            }

            if (K==0) return sum;

            int left=0;
            int right=sum/K + sum%K;
            int ans = 0;
            while(left<=right) {
                int mid = left + ((right-left)/2);
                if (can(sweetness, mid, K)) {
                    ans = mid;
                    left = mid+1;
                } else {
                    right = mid-1;
                }
            }
            return ans;
        }

        private boolean can(int[] arr, int min, int K) {
            int count = 0;
            int sum = 0;
            for (int i=0; i<arr.length; i++) {
                sum+=arr[i];
                if (sum >= min) {
                    count++;
                    sum = 0;
                    if (count > K) return true;
                }
            }
            if (sum >= min) {
                count++;
            }
            return count > K;
        }
    }
}
