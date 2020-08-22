package com.sudhar.examples;

import java.util.HashMap;
import java.util.Map;

public class SparseMatrixMultiplication {

//    Given two sparse matrices A and B, return the result of AB.
//
//    You may assume that A's column number is equal to B's row number.
//
//            Example:
//
//    Input:
//
//    A = [
//            [ 1, 0, 0],
//            [-1, 0, 3]
//            ]
//
//    B = [
//            [ 7, 0, 0 ],
//            [ 0, 0, 0 ],
//            [ 0, 0, 1 ]
//            ]
//
//    Output:
//
//            |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
//    AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
//            | 0 0 1 |


    class Solution {
        public int[][] multiply(int[][] A, int[][] B) {
            // construct the map for A
            // map: row index, map<column index, value>
            Map<Integer, Map<Integer, Integer>> amap = new HashMap<>();
            for(int row = 0; row< A.length; row++) {
                for(int column = 0; column< A[0].length; column++) {
                    Map<Integer, Integer> tmap = amap.getOrDefault(row, new HashMap<>());
                    if (A[row][column] != 0) {
                        tmap.put(column, A[row][column]);
                        amap.put(row, tmap);
                    }
                }
            }
            // constuct the amp for B
            // map: column index, map<row index, value>
            Map<Integer, Map<Integer, Integer>> bmap = new HashMap<>();
            for(int row = 0; row< B.length; row++) {
                for(int column = 0; column< B[0].length; column++) {
                    Map<Integer, Integer> tmap = bmap.getOrDefault(column, new HashMap<>());
                    if(B[row][column] != 0) {
                        tmap.put(row, B[row][column]);
                        bmap.put(column, tmap);
                    }
                }
            }
            // result matrix size is A's row length * B's column length
            int[][] result = new int[A.length][B[0].length];
            for(int row: amap.keySet()) { // get only valid row from A
                for(int col: bmap.keySet()) { // get only valid column from B
                    int sum = 0;
                    // calculate result[row][col]: aCol0*bRow0 + aCol1*bRow1 .. + aColn*bRown. Just check none zero values.
                    for(int acol: amap.get(row).keySet()) {
                        if(bmap.get(col).containsKey(acol)) {
                            sum += amap.get(row).get(acol) * bmap.get(col).get(acol);
                        }
                    }
                    result[row][col] = sum;
                }
            }
            return result;
        }
    }
}

