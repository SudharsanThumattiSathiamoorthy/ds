package com.sudhar.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PathWithMaximumMinimumValue {
//
//    Given a matrix of integers A with R rows and C columns, find the maximum score of a path starting at [0,0] and ending at [R-1,C-1].
//
//    The score of a path is the minimum value in that path.  For example, the value of the path 8 →  4 →  5 →  9 is 4.
//
//    A path moves some number of times from one visited cell to any neighbouring unvisited cell in one of the 4 cardinal directions (north, east, west, south).
//
//
//
//    Example 1:
//
//
//
//    Input: [[5,4,5],[1,2,6],[7,4,6]]
//    Output: 4
//    Explanation:
//    The path with the maximum score is highlighted in yellow.
//    Example 2:
//
//
//
//    Input: [[2,2,1,2,2,2],[1,2,2,2,1,2]]
//    Output: 2
//    Example 3:
//
//
//
//    Input: [[3,4,6,3,4],[0,2,1,1,7],[8,8,3,2,7],[3,2,4,9,8],[4,1,2,0,0],[4,6,5,4,3]]
//    Output: 3
//
//
//    Note:
//
//            1 <= R, C <= 100
//            0 <= A[i][j] <= 10^9

    class Solution1 {
        public String minWindow(String S, String T) {
            int N = S.length();
            int[] last = new int[26];
            int[][] nxt = new int[N][26];
            Arrays.fill(last, -1);

            for (int i = N - 1; i >= 0; --i) {
                last[S.charAt(i) - 'a'] = i;
                for (int k = 0; k < 26; ++k) {
                    nxt[i][k] = last[k];
                }
            }

            List<int[]> windows = new ArrayList();
            for (int i = 0; i < N; ++i) {
                if (S.charAt(i) == T.charAt(0))
                    windows.add(new int[]{i, i});
            }
            for (int j = 1; j < T.length(); ++j) {
                int letterIndex = T.charAt(j) - 'a';
                for (int[] window: windows) {
                    if (window[1] < N-1 && nxt[window[1]+1][letterIndex] >= 0) {
                        window[1] = nxt[window[1]+1][letterIndex];
                    }
                    else {
                        window[0] = window[1] = -1;
                        break;
                    }
                }
            }

            int[] ans = {-1, S.length()};
            for (int[] window: windows) {
                if (window[0] == -1) break;
                if (window[1] - window[0] < ans[1] - ans[0]) {
                    ans = window;
                }

            }
            return ans[0] >= 0 ? S.substring(ans[0], ans[1] + 1) : "";
        }
    }

    class Solution {
        public String minWindow(String S, String T) {
            int[][] dp = new int[2][S.length()];

            for (int i = 0; i < S.length(); ++i)
                dp[0][i] = S.charAt(i) == T.charAt(0) ? i : -1;

        /*At time j when considering T[:j+1],
          the smallest window [s, e] where S[e] == T[j]
          is represented by dp[j & 1][e] = s, and the
          previous information of the smallest window
          [s, e] where S[e] == T[j-1] is stored as
          dp[~j & 1][e] = s.
        */
            for (int j = 1; j < T.length(); ++j) {
                int last = -1;
                Arrays.fill(dp[j & 1], -1);
                //Now we would like to calculate the candidate windows
                //"dp[j & 1]" for T[:j+1].  'last' is the last window seen.
                for (int i = 0; i < S.length(); ++i) {
                    if (last >= 0 && S.charAt(i) == T.charAt(j))
                        dp[j & 1][i] = last;
                    if (dp[~j & 1][i] >= 0)
                        last = dp[~j & 1][i];
                }
            }

            //Looking at the window data dp[~T.length & 1],
            //choose the smallest length window [s, e].
            int start = 0, end = S.length();
            for (int e = 0; e < S.length(); ++e) {
                int s = dp[~T.length() & 1][e];
                if (s >= 0 && e - s < end - start) {
                    start = s;
                    end = e;
                }
            }
            return end < S.length() ? S.substring(start, end+1) : "";
        }
    }

}
