package com.sudhar.examples;

// https://leetcode.com/problems/most-frequent-subtree-sum/description/

// Input:root=[5,2,-3]
// Output:[2,-3,4]

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MostFrequentSubTreeSum {
    int maxCount = 0;

    Map<Integer, Integer> map = new HashMap<>();

    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) {
            return null;
        }

        traverseGraph(root);

        List<Integer> maxCountList = map.entrySet().stream()
                .filter(entrySet -> entrySet.getValue() == maxCount)
                .map(Map.Entry::getKey)
                .toList();


        return maxCountList.stream().mapToInt(Integer::intValue).toArray();
    }

    private int traverseGraph(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = traverseGraph(root.left);
        int right = traverseGraph(root.right);

        int val = left + right + root.val;

        map.put(val, map.getOrDefault(val, 0) + 1);

        maxCount = Math.max(maxCount, map.get(val));

        return val;
    }
}
