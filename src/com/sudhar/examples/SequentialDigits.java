package com.sudhar.examples;

import java.util.ArrayList;
import java.util.List;

public class SequentialDigits {
//
//    Input: low = 100, high = 300
//    Output: [123,234]

//    Input: low = 1000, high = 13000
//    Output: [1234,2345,3456,4567,5678,6789,12345]

    public List<Integer> sequentialDigits(int low, int high) {
        int lowLen = ("" + low).length(), highLen  = ("" +high).length();

        String str = "123456789";
        List<Integer> result = new ArrayList<>();

        for (int len= lowLen; len <= highLen; len++) {
            for (int j = 0; j <= 9 - len; j++) {
                String temp = str.substring(j, j + len);
                Integer num = Integer.parseInt(temp);

                if (num > high) {
                    return result;
                }
                //if (num >= low && num <= high) {
                    result.add(num);
                //}
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SequentialDigits sd = new SequentialDigits();

        System.out.println(sd.sequentialDigits(1000, 13000));
    }

}
