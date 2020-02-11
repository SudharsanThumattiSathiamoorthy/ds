package com.sudhar.examples;

import java.util.HashMap;
import java.util.Map;

public class TrappingRainWater {

    public static void main(final String[] args) {
        int a[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};


        System.out.println(findWaterAmount(a));
    }

    private static int findWaterAmount(int[] a) {
        if (a == null || a.length == 0) {
            return 0;
        }

        int result = 0, leftMax = 0, rightMax = 0, lo = 0, hi = a.length - 1;

        while (lo <= hi) {

            if (a[lo] < a[hi]) {
                if (a[lo] > leftMax) {
                    leftMax = a[lo];
                } else {
                    result += leftMax - a[lo];
                }

                lo++;
            } else {

                if (a[hi] > rightMax) {
                    rightMax = a[hi];
                } else {
                    result += rightMax - a[hi];
                }

                hi--;
            }

        }

        return result;
    }
}
