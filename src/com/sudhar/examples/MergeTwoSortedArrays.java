package com.sudhar.examples;

import java.util.Arrays;

public class MergeTwoSortedArrays {

    public static void main(String[] args) {

        int a1[] = {0,0,3,0,0,0,0,0,0};
        int a2[] = {-1,1,1,1,2,3};

        MergeTwoSortedArrays mergeTwoSortedArrays = new MergeTwoSortedArrays();
        // System.out.println(Arrays.toString(mergeTwoArrays(a1, a2)));
        mergeTwoSortedArrays.merge(a1, 3, a2, 6);
        System.out.println(Arrays.toString(a1));
    }

    public static int[] mergeTwoArrays(int[] a1, int[] a2) {
        if (a1 == null && a2  == null) {
            return null;
        }

        if (a1 == null) {
            return a2;
        }

        if (a2 == null) {
            return a1;
        }

        int i = a1.length-1, j = a2.length-1;

        // a1 = Arrays.copyOf(a1, a1.length + a2.length);

        int a1Size = a1.length - 1;

        while (i >= 0 && j >= 0) {
            if (a2[j] >= a1[i]) {
                a1[a1Size--] = a2[j];
                j--;
            } else {
                a1[a1Size--] = a1[i];
                i--;
            }
        }

        return a1;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null) {
            return;
        }

        if (nums1.length == 0) {
            nums1 = nums2;
        }

        int c1= m -1, c2 = n-1;
        int ci  = m+n-1;

        while (c1 >= 0 && c2 >= 0) {
            if (nums1[c1] >= nums2[c2]) {
                nums1[ci] = nums1[c1];
                c1--;
                ci--;
            } else {
                nums1[ci] = nums2[c2];
                c2--;
                ci--;
            }
        }

        while (c2 >= 0 && ci >= 0) {
            nums1[ci] = nums2[c2];
            c2--;
            ci--;
        }

    }
}
