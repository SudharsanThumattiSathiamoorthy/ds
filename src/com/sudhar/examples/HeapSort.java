package com.sudhar.examples;

import java.util.Arrays;

public class HeapSort {

    public static void main(final String[] args) {
        int a[] = {5, 7, 1, 2, 4};

        heapSort(a);

        System.out.println(Arrays.toString(a));
    }

    private static void heapSort(int[] a) {
        if (a == null || a.length == 0) {
            return;
        }

        int n = a.length;
        for (int i = a.length/ 2 - 1; i >= 0; i--) {
            heapify(a, i, a.length);
        }

        for (int i = n-1; i >= 0; i--) {
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;

            heapify(a, 0, i);
        }
    }

    private static void heapify(int[] a, int i, int n) {
        int largest  = i;

        int lc = 2 * i + 1;
        int rc = 2 * i + 2;

        if (lc < n && a[lc] > a[largest]) {
            largest = lc;
        }

        if (rc < n && a[rc] > a[largest]) {
            largest = rc;
        }

        if (largest != i) {
            int temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;

            heapify(a, largest, n);
        }
    }

//    private static void heapSort(int[] a) {
//
//        int n = a.length;
//
//        for (int i = a.length / 2 - 1; i >= 0; i--) {
//            heapify(a, i, n);
//        }
//
//        for (int i = n - 1; i >= 0; i--) {
//            int temp = a[0];
//            a[0] = a[i];
//            a[i] = temp;
//
//            heapify(a, 0, i);
//        }
//    }
//
//    private static void heapify(int[] a, int i, int n) {
//        int largest = i;
//        int li = 2 * i + 1;
//        int ri = 2 * i + 2;
//
//        if (li < n && a[li] > a[largest]) {
//            largest = li;
//        }
//
//        if (ri < n && a[ri] > a[largest]) {
//            largest = ri;
//        }
//
//        if (largest != i) {
//            int temp = a[i];
//            a[i] = a[largest];
//            a[largest] = temp;
//
//            heapify(a, largest, n);
//        }
//    }

//    private static void swap(int[] a, int i, int j) {
//        int temp = a[i];
//        a[i] = a[j];
//        a[j] = temp;
//    }

//    public static void heapSort(int arr[])
//    {
//        int n = arr.length;
//
//        for (int i = n / 2 - 1; i >= 0; i--)
//            heapify(arr, n, i);
//
//        for (int i=n-1; i>=0; i--)
//        {
//            // Move current root to end
//            int temp = arr[0];
//            arr[0] = arr[i];
//            arr[i] = temp;
//
//            // call max heapify on the reduced heap
//            heapify(arr, i, 0);
//        }
//    }
//
//    // To heapify a subtree rooted with node i which is
//    // an index in arr[]. n is size of heap
//    static void heapify(int arr[], int n, int i)
//    {
//        int largest = i;  // Initialize largest as root
//        int l = 2*i + 1;  // left = 2*i + 1
//        int r = 2*i + 2;  // right = 2*i + 2
//
//        // If left child is larger than root
//        if (l < n && arr[l] > arr[largest])
//            largest = l;
//
//        // If right child is larger than largest so far
//        if (r < n && arr[r] > arr[largest])
//            largest = r;
//
//        // If largest is not root
//        if (largest != i)
//        {
//            int swap = arr[i];
//            arr[i] = arr[largest];
//            arr[largest] = swap;
//
//            // Recursively heapify the affected sub-tree
//            heapify(arr, n, largest);
//        }
//    }
}
