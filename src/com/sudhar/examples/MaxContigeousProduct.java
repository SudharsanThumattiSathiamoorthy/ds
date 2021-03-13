package com.sudhar.examples;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaxContigeousProduct {

//    public static void main(final String[] args) {
//        int max = 1, max_so_far = 1, min = 1;
//
//        int a[] = {1, -2, -3, 0, 7, -8, -2};
//
//        for (int i = 0; i < a.length; i++) {
//            if (a[i] > 0) {
//                max *= a[i];
//                min = Math.min(a[i] * min, 1);
//            } else if (a[i] == 0) {
//                max = 1;
//                min = 1;
//            } else {
//                int temp = max;
//                max = Math.max(min * a[i], 1);
//                min = temp * a[i];
//            }
//
//            if (max_so_far < max) {
//                max_so_far = max;
//            }
//        }
//        System.out.println(max_so_far);
//    }

    public static void main(final String[] args) {
        Set<Set<Integer>> result = new HashSet<>();

        List<List<Integer>> resultList = new ArrayList<>();

        for (Set<Integer> set: result) {
            List<Integer> list = new ArrayList<>();
            list.addAll(set);
            resultList.add(list);
        }

    }







}
