package com.sudhar.examples;

public class NumberToHexaDecimal {

    public static void main(String[] args) {

        NumberToHexaDecimal n = new NumberToHexaDecimal();

        System.out.println(n.toHex(26));

        System.out.println(n.toHex(-1));
    }

    public String toHex(int no) {
        if (no == 0) {
            return "";
        }

        char[] codes = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        StringBuilder sb = new StringBuilder();

        while (no != 0) {
            char c = codes[no & 0b1111];

            sb.append(c);

            no = (no >>> 4);
        }

        return sb.reverse().toString();
    }
}
