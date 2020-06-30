package com.sudhar.examples;

public class SingleNumber {

    public static void main(String[] args) {

        SingleNumber s = new SingleNumber();

        System.out.println(s.findSingleNumber(new int[] {1,1,2,3,3,4,4}));
    }

    public int findSingleNumber(int[] nos) {
        int x = 0;

        for (int no: nos) {
            x = x ^ no;
        }

        return x;
    }
}
