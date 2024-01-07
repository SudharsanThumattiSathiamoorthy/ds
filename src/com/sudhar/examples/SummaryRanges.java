package com.sudhar.examples;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {

        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        int start = 0, end = 0;

        while (end < nums.length) {



            while (end < nums.length - 1 && nums[end] + 1==  nums[end+1]) {
                end++;
            }
            // System.out.println("start : " + start + " end : " + end);

            if (nums[start] != nums[end]) {
                result.add(nums[start] + "->" + nums[end]);
            } else {
                result.add("" + nums[start]);
            }
            start = end;
            start++;
            end++;

            // System.out.println("start : " + start + " end : " + end);
        }

//        Input: nums = [0,1,2,4,5,7]
//        Output: ["0->2","4->5","7"]
//        Explanation: The ranges are:
//[0,2] --> "0->2"
//                [4,5] --> "4->5"
//                [7,7] --> "7"

        return result;
    }
}
