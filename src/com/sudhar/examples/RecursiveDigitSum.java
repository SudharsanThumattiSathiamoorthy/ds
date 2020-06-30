package com.sudhar.examples;

public class RecursiveDigitSum {

    public static void main(String[] args) {
        superDigit("9875", 4);
    }

    static int superDigit(String n, int k) {
        if (n == null || n.length() == 0) {
            return 0;
        }

        int temp = 0;
        for (int i = 0; i < k; i++) {
            temp += Integer.valueOf(computeSum(n));
        }

        String sum = String.valueOf(temp);
        while (sum.length() > 1) {
            sum = computeSum(sum);
            System.out.println(sum);
        }
        return Integer.valueOf(sum);
    }

    private static String computeSum(String k) {
        int sum = 0;

        char[] nos = k.toCharArray();
        for (int i = 0; i < k.length(); i++) {
            sum += Character.getNumericValue(nos[i]);
            //System.out.println("From Loop: " + sum);
        }

        return String.valueOf(sum);
    }

//    static int superDigit(String n, int k) {
//        n = n.chars().mapToLong(Character::getNumericValue).sum() * k
//            + "";
//        return (n.length() > 1) ? superDigit(n, 1) :
//               Character.getNumericValue(n.charAt(0));
//    }
}
