package com.sudhar.examples;

import java.util.ArrayList;
import java.util.List;

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
            for (int j = 1; j < sum + 1; ++j) {
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

        //printAllSubsets(arr, n, sum);


        List<List<Integer>> result = new ArrayList<>();
        findAllSubsets(arr, new int[arr.length], 0, 0, 5, result);

        System.out.println(result);;
    }

    private static void findAllSubsets(int[] a, int[] visited, int ci, int currentSum, int targetSum, List<List<Integer>> result) {
        if (currentSum == targetSum) {
            findSubset(a, visited, ci, result);
        } else if (ci == a.length) {
            return;
        } else {
            visited[ci] = 1;
            currentSum += a[ci];
            findAllSubsets(a, visited, ci +1, currentSum, targetSum, result);

            visited[ci] = 0;
            currentSum -= a[ci];
            findAllSubsets(a, visited, ci + 1, currentSum, targetSum, result);
        }
    }

//    private static void findAllSubsets(int[] a, boolean[] visited, int ci, int sum, List<List<Integer>> result) {
//        if (sum == 0) {
//            findSubset(a, visited, ci, result);
//
//            return;
//        } else if (ci == a.length) {
//            return;
//        } else {
//            for (int i = ci; i < a.length; i++) {
//                visited[i] = true;
//                sum -= a[i];
//                findAllSubsets(a, visited, ci + 1, sum, result);
//                visited[i] = false;
//                sum += a[i];
//                findAllSubsets(a, visited, ci + 1, sum, result);
//            }
//        }
//    }

    private static void findSubset(int[] a, int[] visited, int ci, List<List<Integer>> result) {
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < ci; i++) {
            if (visited[i] == 1) {
                temp.add(a[i]);
            }
        }

        if (temp.size() != 0) {
            result.add(temp);
        }
    }
}
