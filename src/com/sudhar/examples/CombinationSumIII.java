package com.sudhar.examples;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

    class Solution2 {
        public List<List<Integer>> combinationSum3(int k, int n) {
            if (k == 0) {
                return new ArrayList<>();
            }

            List<List<Integer>> result = new ArrayList<>();
            findAllCombinations(k, n, 1, new ArrayList<>(), result);

            return result;
        }

        private void findAllCombinations(int k, int target, int ci, List<Integer> currList, List<List<Integer>> result) {

            if (currList.size() == k && target == 0) {
                result.add(new ArrayList<>(currList));
                return;
            }

            for (int i = ci; i <= 9; i++) {
                currList.add(i);
                findAllCombinations(k, target - i, i+1, currList, result);
                currList.remove(currList.size() - 1);
            }
        }
    }

    class Solution1 {
        public List<List<Integer>> combinationSum3(int k, int n) {
            if (k == 0) {
                return new ArrayList<>();
            }
//            Input: k = 3, n = 7
//            Output: [[1,2,4]]

//            Input: k = 3, n = 9
//            Output: [[1,2,6], [1,3,5], [2,3,4]]

            List<List<Integer>> result = new ArrayList<>();

            findAllCombinations(k, n, 1, new ArrayList<>(), result);

            return result;
        }

        private void findAllCombinations(int k, int target, int ci, List<Integer> currList, List<List<Integer>> result) {

            if (currList.size() == k && target == 0) {
                result.add(new ArrayList<>(currList));
                return;
            }

            for (int i = ci; i <= 9; i++) {
                currList.add(i);
                findAllCombinations(k, target - i, i+1, currList, result);
                currList.remove(currList.size() - 1);
            }
        }
    }
}
