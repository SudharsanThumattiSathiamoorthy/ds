package com.sudhar.examples;

public class MissingElementInSortedArray {

//    Given a sorted array A of unique numbers, find the K-th missing number starting from the leftmost number of the array.
//
//
//
//            Example 1:
//
//    Input: A = [4,7,9,10], K = 1
//    Output: 5
//    Explanation:
//    The first missing number is 5.
//    Example 2:
//
//    Input: A = [4,7,9,10], K = 3
//    Output: 8
//    Explanation:
//    The missing numbers are [5,6,8,...], hence the third missing number is 8.
//    Example 3:
//
//    Input: A = [1,2,4], K = 3
//    Output: 6
//    Explanation:
//    The missing numbers are [3,5,6,7,...], hence the third missing number is 6.

    class Solution1 {
        // Return how many numbers are missing until nums[idx]
        int missing(int idx, int[] nums) {
            return nums[idx] - nums[0] - idx;
        }

        public int missingElement(int[] nums, int k) {
            int n = nums.length;
            // If kth missing number is larger than
            // the last element of the array
            if (k > missing(n - 1, nums))
                return nums[n - 1] + k - missing(n - 1, nums);

            int idx = 1;
            // find idx such that
            // missing(idx - 1) < k <= missing(idx)
            while (missing(idx, nums) < k) idx++;

            // kth missing number is greater than nums[idx - 1]
            // and less than nums[idx]
            return nums[idx - 1] + k - missing(idx - 1, nums);
        }
    }

    class Solution2 {
        // Return how many numbers are missing until nums[idx]
        int missing(int idx, int[] nums) {
            return nums[idx] - nums[0] - idx;
        }

        public int missingElement(int[] nums, int k) {
            int n = nums.length;
            // If kth missing number is larger than
            // the last element of the array
            if (k > missing(n - 1, nums))
                return nums[n - 1] + k - missing(n - 1, nums);

            int left = 0, right = n - 1, pivot;
            // find left = right index such that
            // missing(left - 1) < k <= missing(left)
            while (left != right) {
                pivot = left + (right - left) / 2;

                if (missing(pivot, nums) < k) left = pivot + 1;
                else right = pivot;
            }

            // kth missing number is greater than nums[idx - 1]
            // and less than nums[idx]
            return nums[left - 1] + k - missing(left - 1, nums);
        }
    }

}
