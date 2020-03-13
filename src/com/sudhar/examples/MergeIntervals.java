package com.sudhar.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {

        MergeIntervals mi = new MergeIntervals();

        System.out.println(mi.mergeIntervals(new int[][]{{1,3},{2,6},{8,10},{15,18}}));
    }

    public int[][] mergeIntervals(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));

        int[] curr = intervals[0];
        List<int[]> result = new ArrayList<>();
        result.add(curr);

        for (int[] interval: intervals) {
            int currBegining = curr[0];
            int currEnd = curr[1];

            int nextBegining = interval[0];
            int nextEnd = interval[1];

            if (currEnd >= nextBegining) {
                curr[1] = Math.max(currEnd, nextEnd);
            } else {
                curr = interval;
                result.add(curr);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
