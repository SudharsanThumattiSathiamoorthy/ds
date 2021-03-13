package com.sudhar.examples;

import java.util.Arrays;

public class RemoveDuplicatesInArray {

    public static void main(String[] args) {
        RemoveDuplicatesInArray r = new RemoveDuplicatesInArray();
        System.out.println(r.removeDuplicates(new int[] {0,1,1,1,1,2,2,3,3,4}));
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length <= 2) {
            return nums.length;
        }

        int curr = nums[0], i = 1, index = 0, count = 1;

        while (i < nums.length) {
            while (i < nums.length && nums[i] == curr) {
                i++;
                count++;
            }

            curr = nums[i];
            if (count > 1) {
                count  = 1;
                nums[index + 1] = nums[i];
            }
            index++;
            i++;
        }

        System.out.println(Arrays.toString(nums));
        return index;
    }

}
