package com.sudhar.examples;

public class DecodeWaysII {

//    A message containing letters from A-Z is being encoded to numbers using the following mapping way:
//
//            'A' -> 1
//            'B' -> 2
//            ...
//            'Z' -> 26
//    Beyond that, now the encoded string can also contain the character '*', which can be treated as one of the numbers from 1 to 9.
//
//    Given the encoded message containing digits and the character '*', return the total number of ways to decode it.
//
//    Also, since the answer may be very large, you should return the output mod 109 + 7.
//
//    Example 1:
//    Input: "*"
//    Output: 9
//    Explanation: The encoded message can be decoded to the string: "A", "B", "C", "D", "E", "F", "G", "H", "I".
//    Example 2:
//    Input: "1*"
//    Output: 9 + 9 = 18

    public class Solution1 {
        int M = 1000000007;
        public int numDecodings(String s) {
            Integer[] memo=new Integer[s.length()];
            return ways(s, s.length() - 1,memo);
        }
        public int ways(String s, int i,Integer[] memo) {
            if (i < 0)
                return 1;
            if(memo[i]!=null)
                return memo[i];
            if (s.charAt(i) == '*') {
                long res = 9 * ways(s, i - 1,memo);
                if (i > 0 && s.charAt(i - 1) == '1')
                    res = (res + 9 * ways(s, i - 2,memo)) % M;
                else if (i > 0 && s.charAt(i - 1) == '2')
                    res = (res + 6 * ways(s, i - 2,memo)) % M;
                else if (i > 0 && s.charAt(i - 1) == '*')
                    res = (res + 15 * ways(s, i - 2,memo)) % M;
                memo[i]=(int)res;
                return memo[i];
            }
            long res = s.charAt(i) != '0' ? ways(s, i - 1,memo) : 0;
            if (i > 0 && s.charAt(i - 1) == '1')
                res = (res + ways(s, i - 2,memo)) % M;
            else if (i > 0 && s.charAt(i - 1) == '2' && s.charAt(i) <= '6')
                res = (res + ways(s, i - 2,memo)) % M;
            else if (i > 0 && s.charAt(i - 1) == '*')
                res = (res + (s.charAt(i)<='6'?2:1) * ways(s, i - 2,memo)) % M;
            memo[i]= (int)res;
            return memo[i];
        }
    }

    public class Solution2 {
        int M = 1000000007;
        public int numDecodings(String s) {
            long[] dp = new long[s.length() + 1];
            dp[0] = 1;
            dp[1] = s.charAt(0) == '*' ? 9 : s.charAt(0) == '0' ? 0 : 1;
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == '*') {
                    dp[i + 1] = 9 * dp[i];
                    if (s.charAt(i - 1) == '1')
                        dp[i + 1] = (dp[i + 1] + 9 * dp[i - 1]) % M;
                    else if (s.charAt(i - 1) == '2')
                        dp[i + 1] = (dp[i + 1] + 6 * dp[i - 1]) % M;
                    else if (s.charAt(i - 1) == '*')
                        dp[i + 1] = (dp[i + 1] + 15 * dp[i - 1]) % M;
                } else {
                    dp[i + 1] = s.charAt(i) != '0' ? dp[i] : 0;
                    if (s.charAt(i - 1) == '1')
                        dp[i + 1] = (dp[i + 1] + dp[i - 1]) % M;
                    else if (s.charAt(i - 1) == '2' && s.charAt(i) <= '6')
                        dp[i + 1] = (dp[i + 1] + dp[i - 1]) % M;
                    else if (s.charAt(i - 1) == '*')
                        dp[i + 1] = (dp[i + 1] + (s.charAt(i) <= '6' ? 2 : 1) * dp[i - 1]) % M;
                }
            }
            return (int) dp[s.length()];
        }
    }

    public class Solution {
        int M = 1000000007;
        public int numDecodings(String s) {
            long first = 1, second = s.charAt(0) == '*' ? 9 : s.charAt(0) == '0' ? 0 : 1;
            for (int i = 1; i < s.length(); i++) {
                long temp = second;
                if (s.charAt(i) == '*') {
                    second = 9 * second;
                    if (s.charAt(i - 1) == '1')
                        second = (second + 9 * first) % M;
                    else if (s.charAt(i - 1) == '2')
                        second = (second + 6 * first) % M;
                    else if (s.charAt(i - 1) == '*')
                        second = (second + 15 * first) % M;
                } else {
                    second = s.charAt(i) != '0' ? second : 0;
                    if (s.charAt(i - 1) == '1')
                        second = (second + first) % M;
                    else if (s.charAt(i - 1) == '2' && s.charAt(i) <= '6')
                        second = (second + first) % M;
                    else if (s.charAt(i - 1) == '*')
                        second = (second + (s.charAt(i) <= '6' ? 2 : 1) * first) % M;
                }
                first = temp;
            }
            return (int) second;
        }
    }

}
