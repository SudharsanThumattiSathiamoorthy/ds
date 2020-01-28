package com.sudhar.examples;

import java.util.*;

public class FourSum {

    public static void main(final String[] args) {
        FourSum fs = new FourSum();

        System.out.println(fs.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }

    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(num);

        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                int start = j + 1, end = num.length - 1;

                while (start < end) {
                    int sum = num[i] + num[j] + num[start] + num[end];

                    if (sum == target) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(num[i]);
                        temp.add(num[j]);
                        temp.add(num[start]);
                        temp.add(num[end]);
                        result.add(temp);

                        start++;
                        end--;

                        while (start < end && num[start] == num[start - 1]) start++;
                        while (start < end && num[end] == num[end + 1]) end--;
                    } else if (sum < target) {
                        start++;

                        while (start < end && num[start] == num[start - 1]) start++;
                    } else {
                        end--;

                        while (start < end && num[end] == num[end + 1]) end--;
                    }
                }

                while (j + 1 < num.length && num[j + 1] == num[j]) j++;
            }

            while (i + 1 < num.length && num[i + 1] == num[i]) i++;
        }

        return result;
    }
}
