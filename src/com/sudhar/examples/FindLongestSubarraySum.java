package com.sudhar.examples;

import java.util.Arrays;

public class FindLongestSubarraySum {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 0, 0, 0, 6, 7, 8, 9, 10};
        int s = 15;

        int left = 0, right = 0, sum = 0;
        int[] result = new int[]{-1};

        while (right < a.length) {
            sum += a[right];

            while (sum > s && left < right) {
                sum -= a[left];
                left++;
            }

            if (sum == s && (result.length == 1 || result[1] - result[0] < right - left)) {
                result = new int[]{left + 1, right + 1};
            }

            right++;
        }

        System.out.println(Arrays.toString(result));
    }
}
