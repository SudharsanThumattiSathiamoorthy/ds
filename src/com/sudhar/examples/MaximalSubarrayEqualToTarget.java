package com.sudhar.examples;

import java.util.HashMap;
import java.util.Map;

public class MaximalSubarrayEqualToTarget {

    public static void main(String[] args) {
        int[] a = {15, -2, 2, -8, 1, 7, 10, 23};

        System.out.println(findMaximalSubarray(a));
    }

    private static boolean findMaximalSubarray(int[] a) {
        if (a == null || a.length == 0) {
            return false;
        }

        int sum = 0, max = -1;

        Map<Integer, Integer> map = new HashMap<>();


        return false;
    }

}
