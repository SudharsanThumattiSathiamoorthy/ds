package com.sudhar.examples;

public class AddTwoBinaryNos {


        public String addBinary(String a, String b) {

            if (a == null || a.length() == 0) {
                return b;
            }

            if (b == null || b.length() == 0) {
                return a;
            }

            int i = a.length() -1, j = b.length() -1;
            int carry = 0;
            StringBuilder result = new StringBuilder();

            while (i >= 0 || j >= 0) {
                int x = i >= 0 ? a.charAt(i) - '0' : 0;
                int y = j >= 0 ? b.charAt(j) - '0' : 0;

                int sum = x + y + carry;
                if (sum == 0) {
                    result.append("0");
                    carry = 0;
                } else if (sum == 1) {
                    result.append("1");
                    carry =0;
                } else if (sum == 2) {
                    result.append("0");
                    carry = 1;
                } else if (sum == 3) {
                    result.append("1");
                    carry = 1;
                }
                i--;
                j--;
            }

            if (carry == 1) {
                result.append("1");
            }
            return result.reverse().toString();

        }
}
