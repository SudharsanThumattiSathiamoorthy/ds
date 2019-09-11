package com.sudhar.examples;

import java.util.ArrayList;
import java.util.List;

public class FibonacciSubSetProblem {

    public static void main(final String[] args) {
        int num = 17;

        if (num <= 1) {
            return;
        }

        List<Integer> result = new ArrayList<>();
        Integer arr[] = generateFib(num);

        dfs(num, arr, result, new ArrayList<>(), arr.length -1);
        System.out.println(result);
    }

    private static void dfs(int num, Integer[] arr, List<Integer> result, ArrayList<Object> temp, int curr) {
        if (num < 0) {
            return;
        } else if (num == 0) {
            int[] tempArr  = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                if (temp.contains(arr[i])) {
                    tempArr[tempArr.length - 1 -i] = 1;
                } else {
                    tempArr[tempArr.length - 1 -i] = 0;
                }
            }

            int tempRes = 0;
            for (int i = 0; i < arr.length; i++) {
                tempRes = tempRes * 10 + tempArr[i];
            }

            result.add(tempRes);
        } else {
            for (int i = curr; i >= 0; i--) {
                temp.add(arr[i]);
                dfs(num -arr[i], arr, result, temp, i - 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private static Integer[] generateFib(int num) {
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(1);

        while (list.get(list.size() - 1) < num) {
            list.add(list.get(list.size()-1 ) + list.get(list.size() -2));
        }
        list.remove(0);
        System.out.println("Fib : " + list);

        return list.toArray(new Integer[list.size()]);
    }

}
