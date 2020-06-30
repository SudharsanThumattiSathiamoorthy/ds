package com.sudhar.examples;

public class PowerOfTwo {

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(-2147483648));
    }

    public static boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }

        for (int i = 0; i < 31; i++) {
            int no = 1 << i;
            System.out.println(no);
            if (no == n) {
                return true;
            }
        }

        return false;
    }
}
