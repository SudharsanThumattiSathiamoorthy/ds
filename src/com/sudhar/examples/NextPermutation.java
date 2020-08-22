package com.sudhar.examples;

import java.util.Arrays;

public class NextPermutation {

    public static void main(String[] args) {
//        int[] n1 = {1, 5, 8, 4, 7, 6, 5, 3, 1};
//        new NextPermutation().nextPermutation(n1);
//        System.out.println(Arrays.toString(n1));
//
//        int[] n2 = {1,2,3};
//        new NextPermutation().nextPermutation(n2);
//        System.out.println(Arrays.toString(n2));
//
//        int[] n3 = {3,2,1};
//        new NextPermutation().nextPermutation(n3);
//        System.out.println(Arrays.toString(n3));

        int[] n4 = {1, 5, 1};
        new NextPermutation().nextPermutation(n4);
        System.out.println(Arrays.toString(n4));
    }

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int i = nums.length -1;
        while (i > 0 && nums[i-1] > nums[i]) {
            i--;
        }

        int key = i-1 < 0 ? 0 : i-1;
        int minNoIndex = findMinNoIndex(nums, i, nums[key]);

        swap(nums, key, minNoIndex);

        reverse(nums, i-1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private int findMinNoIndex(int[] nums, int i, int key) {
        int diff = Integer.MAX_VALUE, minIndex = i;
        while (i < nums.length) {
            int temp = Math.abs(nums[i] - key);

            if (temp < diff) {
                minIndex = i;
                diff =  temp;
            }
            i++;
        }
        return minIndex;
    }

    private void reverse(int[] nums,  int index) {

        int i = index, j = nums.length -1;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

            i++;
            j--;
        }
    }

}
