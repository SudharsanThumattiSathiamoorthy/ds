package com.sudhar.examples;

public class NoOfOccurencesInSortedArray {

    public static void main(String[] args) {
        int[] a = {4, 4, 8, 8, 8, 15, 16, 23, 23, 42};

        int target = 23;

        NoOfOccurencesInSortedArray no = new NoOfOccurencesInSortedArray();

        int leftIndex = no.findLeft(a, target);
        // System.out.println(leftIndex);

        int rightIndex = no.findRight(a, target);
        // System.out.println(rightIndex);

        System.out.println((rightIndex - leftIndex) + 1);
    }

    public int findLeft(int[] a, int target) {
        int start = 0, end = a.length - 1;

        while (start <= end) {

            int mid = (start + end) / 2;
            if (a[mid] == target) {
                if (mid - 1 <= 0 || a[mid - 1] < target) {
                    return mid;
                } else {
                    end = mid - 1;
                }

            } else if (a[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    public int findRight(int[] a, int target) {
        int start = 0, end = a.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (a[mid] == target) {
                if (mid + 1 >= a.length || a[mid + 1] > target) {
                    return mid;
                } else {
                    start = mid + 1;
                }
            } else if (a[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
