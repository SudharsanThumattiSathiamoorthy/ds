package com.sudhar.examples;

public class WateringPlants {

    public static void main(String[] args) {

        System.out.println(noOfRefills(new int[]{2, 5, 4, 1, 2}, 5,7));

    }

    public static int noOfRefills(int[] plants, int capacity1, int capacity2) {
        if (plants == null || plants.length == 0) {
            return -1;
        }

        int l = 0, r = plants.length -1, c1 = 0, c2 =0;
        int noOfRefills = 0;

        while (l < r) {
            if (c1 >= plants[l]) {
                c1 -= plants[l];
            } else {
                noOfRefills++;
                c1 = capacity1;
                c1 -= plants[l];

            }

            if (c2 >= plants[r]) {
                c2 -= plants[r];
            } else {
                noOfRefills++;
                c2 = capacity2;

                c2 -= plants[r];
            }

            l++;
            r--;
        }

        if (plants.length %2 == 0) {
            return noOfRefills;
        }

        if (c1 + c2 < plants[l]) {
            noOfRefills++;
        }
        return noOfRefills;
    }
}
