package com.sudhar.examples;

public class FindMinElementInMisplacedCircularSortedArray {

    public static void main(final String[] args) {

        int[] nums = {4, 5, 6, 7, 2, 3};

        System.out.println(findMin(nums));

    }

    private static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.min(nums[0], nums[1]);
        }

        if (nums[0] < nums[nums.length-1]) {
            return nums[0];
        }

        int left = 0, right = nums.length -1;

        while(left < right) {
            int mid = (left + right) / 2;

            if (nums[mid] > nums[mid+1]) {
                return nums[mid+1];
            }

            if (nums[mid] < nums[mid-1]) {
                return nums[mid];
            }

            if (nums[mid] > nums[left]) {
                left = mid +1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
