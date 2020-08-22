package com.sudhar.examples;

public class LemonadeChange {

    public boolean lemonadeChange(int[] bills) {
        if (bills == null || bills.length == 0) {
            return false;
        }

        int[] changes = new int[3];

        for (int bill : bills) {

            if (bill == 5) {
                changes[0]++;
            } else if (bill == 10) {

                if (changes[0] > 0) {
                    changes[0]--;
                } else {
                    return false;
                }
                changes[1]++;
            } else {
                int temp = bill - 5;

                while (temp >= 10 && changes[1] > 0) {
                    temp -= 10;
                    changes[1]--;
                }

                while (temp >= 5 && changes[0] > 0) {
                    temp -= 5;
                    changes[0]--;
                }

                if (temp > 0) {
                    return false;
                }
                changes[2]++;
            }
        }

        return true;
    }

}
