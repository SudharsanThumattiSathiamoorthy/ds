package com.sudhar.examples;

public class DecodeWays {

    public static void main(String[] args) {
        System.out.println(noOfDecodeWays(new int[]{2, 2, 6}));
        System.out.println(countDecodingDP(new char[]{'2', '2', '6'}, 3));
    }

    public static int noOfDecodeWays(int[] a) {
        if (a == null || a.length == 0) {
            return -1;
        }

        int dp[] = new int[a.length + 1];

        dp[0] = dp[1] = 1;

        for (int i = 2; i < dp.length; i++) {
            if (a[i - 1] > 0) {
                dp[i] = dp[i - 1];
            }

            if (a[i - 2] == 1 || a[i - 2] == 2
                    && a[i - 1] < 7) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[a.length];
    }

    static int countDecodingDP(char digits[], int n)
    {
        // A table to store results of subproblems
        int count[] = new int[n + 1];
        count[0] = 1;
        count[1] = 1;
        if(digits[0]=='0')   //for base condition "01123" should return 0
            return 0;
        for (int i = 2; i <= n; i++)
        {
            count[i] = 0;

            // If the last digit is not 0,
            // then last digit must add to
            // the number of words
            if (digits[i - 1] > '0')
                count[i] = count[i - 1];

            // If second last digit is smaller
            // than 2 and last digit is smaller
            // than 7, then last two digits
            // form a valid character
            if (digits[i - 2] == '1' ||
                    (digits[i - 2] == '2' &&
                            digits[i - 1] < '7'))
                count[i] += count[i - 2];
        }
        return count[n];
    }

    class B {

    }

    static class Static {

    }
}
