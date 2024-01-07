package com.sudhar.examples;

// With duplicate elements
public class SearchInRotatedSortedArrayII {

    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        return find(nums, target, start, end);
    }

    public boolean find(int nums[], int target, int start, int end) {
        if (start > end) {
            return false;
        }

        int mid = (start + end) / 2;

        if (nums[mid] == target) {
            return true;
        }

        if ((nums[mid] <= nums[start] && nums[mid] <= nums[end]) || (nums[mid] <= nums[start] && nums[mid] <= nums[end])) {
            return find(nums, target, start, mid - 1) || find(nums, target, mid + 1, end);
        }

        if (nums[start] <= target && nums[mid] >= target) {
            return find(nums, target, start, mid - 1);
        }

        return find(nums, target, mid + 1, end);
    }
}


