package com.sudhar.examples;

import java.util.ArrayList;

public class SubsetProblem {

    static boolean[][] dp;

    static void display(ArrayList<Integer> v)
    {
        System.out.println(v);
    }

    static void printSubsetsRec(int arr[], int n, int sum,
                                ArrayList<Integer> p)
    {
        // If we reached end and sum is non-zero. We print
        // p[] only if arr[0] is equal to sun OR dp[0][sum]
        // is true.
        if (n == 0 && sum != 0 && dp[0][sum])
        {
            p.add(arr[n]);
            display(p);
            p.clear();
            return;
        }

        // If sum becomes 0
        if (n == 0 && sum == 0)
        {
            display(p);
            p.clear();
            return;
        }

        // If given sum can be achieved after ignoring
        // current element.
        if (dp[n-1][sum])
        {
            // Create a new vector to store path
            ArrayList<Integer> b = new ArrayList<>();
            b.addAll(p);
            printSubsetsRec(arr, n-1, sum, b);
        }

        // If given sum can be achieved after considering
        // current element.
        if (sum >= arr[n] && dp[n-1][sum-arr[n]])
        {
            p.add(arr[n]);
            printSubsetsRec(arr, n-1, sum-arr[n], p);
        }
    }

    static void printAllSubsets(int arr[], int n, int sum)
    {
        if (n == 0 || sum < 0)
            return;

        // Sum 0 can always be achieved with 0 elements
        dp = new boolean[n][sum + 1];
        for (int i=0; i<n; ++i)
        {
            dp[i][0] = true;
        }

        // Sum arr[0] can be achieved with single element
        if (arr[0] <= sum)
            dp[0][arr[0]] = true;

        // Fill rest of the entries in dp[][]
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < sum + 1; ++j) {
                //boolean flag = arr[i] <= j;
               // if (flag) {
                    dp[i][j] = (dp[i - 1][j] || dp[i - 1][j - arr[i]]);
//                } else {
//                    dp[i][j] = dp[i - 1][j];
//                }
            }
        }

        if (dp[n-1][sum] == false)
        {
            System.out.println("There are no subsets with" +
                    " sum "+ sum);
            return;
        } else {
            System.out.println("There are subsets found.");
        }

        ArrayList<Integer> p = new ArrayList<>();
        printSubsetsRec(arr, n-1, sum, p);
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4};
        int n = arr.length;
        int sum = 5;

        printAllSubsets(arr, n, sum);

    }
}
