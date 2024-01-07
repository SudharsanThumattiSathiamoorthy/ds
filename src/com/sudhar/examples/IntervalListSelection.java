package com.sudhar.examples;

import java.util.ArrayList;
import java.util.List;

public class IntervalListSelection {

    class Solution {
        public int[][] intervalIntersection(int[][] A, int[][] B) {
            List<int[]> ans = new ArrayList();
            int i = 0, j = 0;

            while (i < A.length && j < B.length) {
                // Let's check if A[i] intersects B[j].
                // lo - the startpoint of the intersection
                // hi - the endpoint of the intersection
                int lo = Math.max(A[i][0], B[j][0]);
                int hi = Math.min(A[i][1], B[j][1]);
                if (lo <= hi)
                    ans.add(new int[]{lo, hi});

                // Remove the interval with the smallest endpoint
                if (A[i][1] < B[j][1])
                    i++;
                else
                    j++;
            }

            return ans.toArray(new int[ans.size()][]);
        }
    }

//    Input: firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]
//    Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]


//    Input: firstList = [[1,3],[5,9]], secondList = []
//    Output: []
}
