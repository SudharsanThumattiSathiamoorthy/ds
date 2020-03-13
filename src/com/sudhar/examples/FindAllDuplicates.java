package com.sudhar.examples;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicates {

    public static void main(String[] args) {
        int[] a = {4,3,2,7,8,2,3,1};

        FindAllDuplicates fad = new FindAllDuplicates();
        System.out.println(fad.findDuplicates(a));
    }

    public List<Integer> findDuplicates(int[] a) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < a.length; i++) {
            int index = Math.abs(a[i]) -1;

            if (a[index] < 0) {
                result.add(Math.abs(a[i]));
            }

            a[index] = -a[index];
        }

        return result;
    }
}
