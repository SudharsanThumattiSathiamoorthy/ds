package com.sudhar.examples;

public class DecodeWays {

    public static void main(String[] args) {
        System.out.println(noOfDecodeWays(new int[]{2, 2, 6}));
        System.out.println(countDecodingDP(new char[]{'2', '2', '6'}, 3));

       // A.C c = new A().new C();

        A.B ab = new A.B();

        A e = new E();
        e.m1();
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

    static int countDecodingDP(char digits[], int n) {
        // A table to store results of subproblems
        int count[] = new int[n + 1];
        count[0] = 1;
        count[1] = 1;
        if (digits[0] == '0')
            return 0;
        for (int i = 2; i <= n; i++) {
            count[i] = 0;

            if (digits[i - 1] > '0')
                count[i] = count[i - 1];

            if (digits[i - 2] == '1' ||
                    (digits[i - 2] == '2' &&
                            digits[i - 1] < '7'))
                count[i] += count[i - 2];
        }
        return count[n];
    }

    // Good solution from leetcode forum.
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= n; i++) {
            int first = Integer.valueOf(s.substring(i - 1, i));
            int second = Integer.valueOf(s.substring(i - 2, i));
            if (first >= 1 && first <= 9) {
                dp[i] += dp[i-1];
            }
            if (second >= 10 && second <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
}

abstract class A {
    static class B {

    }
    public A() {
        System.out.println("A cons");
    }

    class C {

    }

    public void m1() {
        System.out.println("from a");
    }

}

class D extends  A {
    public D() {
        System.out.println("D cons");
    }

    public void m1() {
        System.out.println("from d");
    }
}

class E extends  D {
    public E() {
        System.out.println("E cons");
    }


//    public void m1() {
//        System.out.println("from e");
//    }
}
