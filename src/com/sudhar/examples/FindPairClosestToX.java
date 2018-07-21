package com.sudhar.examples;

public class FindPairClosestToX {

    public static void main(final String[] args) {
        int[] a = {2, 3, 5, 9};
        int x = 47;

        int l = 0, r = a.length - 1, rs_l = 0, rs_r = 0, diff = Integer.MAX_VALUE;

        while(l < r) {
            int res = a[l] * a[r];

            if (x - res  < diff) {
                diff = x - res;

                rs_l = l;

                rs_r = r;
            }


            if (res > x) {
                r--;
            } else {
                l++;
            }
        }

        System.out.println(rs_l + " " + rs_r);
    }
}
