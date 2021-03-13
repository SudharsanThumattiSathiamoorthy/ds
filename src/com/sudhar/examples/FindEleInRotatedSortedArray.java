package com.sudhar.examples;

public class FindEleInRotatedSortedArray {

    public static void main(String[] args) {

        int nums[] = {4, 5, 6, 7, 8, 0, 1, 2};

        // edge cases - {1, 3}, {3, 1}

        System.out.println(search(nums, 5));
    }

    public static int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        int right = nums[nums.length - 1];

        int leftIndex = 0, rightIndex = nums.length - 1;

        while (leftIndex <= rightIndex) {
            int mid = (rightIndex + leftIndex) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                if (nums[mid] >= right && target <= right) {
                    leftIndex = mid + 1;
                } else {
                    rightIndex = mid - 1;
                }
            } else {
                if (nums[mid] <= right && target > right) {
                    rightIndex = mid - 1;
                } else {
                    leftIndex = mid + 1;
                }
            }
        }
        return -1;
    }

    // Optimal solution.
    public int optimalSearch(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] >= nums[start]) {
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target <= nums[end] && target > nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
