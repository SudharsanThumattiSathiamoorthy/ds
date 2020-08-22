package com.sudhar.examples;

import java.util.Arrays;

public class StrobogrammaticNumberIII {

//    A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
//
//    Write a function to count the total strobogrammatic numbers that exist in the range of low <= num <= high.
//
//            Example:
//
//    Input: low = "50", high = "100"
//    Output: 3
//    Explanation: 69, 88, and 96 are three strobogrammatic numbers.
//    Note:
//    Because the range might be a large number, the low and high numbers are represented as string.

    private static final char[] STROBO = new char[]
            //0    1     2      3      4      5      6      7      8     9
            {'0', '1',   0,     0,     0,     0,    '9',    0,    '8',  '6'};
    private static final char[] STROBO_CHARS = new char[]
            {'0', '1', '6', '8', '9'};
    private static final ThreadLocal<int[]> POW5 = new ThreadLocal<>();

    public int strobogrammaticInRange(String low, String high) {
        int ll = low.length();
        int lh = high.length();
        if (lh < ll || (ll == lh && high.compareTo(low) < 0))
            return 0;
        int[] p5 = POW5.get();
        if (lh / 2 > 0 && (p5 == null || p5.length < lh / 2)) {
            int start = p5 == null ? 0 : p5.length;
            int pow = p5 == null ? 1 : p5[start - 1] * 5;
            p5 = p5 == null ? new int[lh / 2] : Arrays.copyOf(p5, lh / 2);
            for (int i = start; i < p5.length; ++i) {
                p5[i] = pow;
                pow *= 5;
            }
            POW5.set(p5);
        }
        char[] nl = low.toCharArray();
        char[] nh = high.toCharArray();
        int count = 0;
        for (int len = ll; len <= lh; ++len) {
            count += countOfLength(len, null, 0, false, false);
        }
        // exclude those below "low"
        count -= countOfLength(ll, nl, 0, true, false);
        // and those above "high"
        count -= countOfLength(lh, nh, 0, false, false);
        return count;
    }

    private static int countOfLength(int len, char[] limit, int limitOffset,
                                     boolean highLimit, boolean inclusive) {
        if (len <= 2) {
            return count12digits(len, limit, limitOffset, highLimit, inclusive);
        }
        // no limit with len >= 2
        if (limit == null) {
            int countAll = POW5.get()[len / 2 - 1];
            if (limitOffset == 0) {
                countAll *= 4; // '0' forbidden
            } else {
                countAll *= 5; // allow '0' in the middle
            }
            if (len % 2 != 0) {
                countAll *= 3;
            }
            return countAll;
        }
        int count = 0;
        // count those with a different MSD (and within the limit)
        int shorterCount = countOfLength(len - 2, null, limitOffset + 1, false, false);
        if (highLimit) {
            int below = 0;//STROBO_DIGITS_BELOW[limit[limitOffset] - '0'];
            if (limitOffset == 0 && below > 0) {
                // '0' not allowed
                --below;
            }
            count += shorterCount * below;
        } else {
            count += shorterCount * 1;// STROBO_DIGITS_ABOVE[limit[limitOffset] - '0'];
        }
        // now for the same MSD
        if (STROBO[limit[limitOffset] - '0'] == 0) {
            return count; // not even a strobo digit
        }
        int lsdDiff = limit[limitOffset + len - 1]
                      - STROBO[limit[limitOffset] - '0'];
        boolean nextInclusive;
        if (lsdDiff > 0) {
            // The LSD is above what it should be,
            // so we need to decrease it to make it a strobo number.
            // So if it's the high limit, then we will be definitely within
            // limit if the rest of the number is unchanged, and if it's
            // the low limit, then we will definitely NOT be within the limit
            // UNLESS we change the rest of the number.
            nextInclusive = highLimit;
        } else if (lsdDiff < 0) {
            // Exactly the opposite of the above.
            nextInclusive = !highLimit;
        } else {
            // If the LSD stays the same it means that the limit stays the same,
            // because we don't change anything.
            nextInclusive = inclusive;
        }
        count += countOfLength(len - 2, limit, limitOffset + 1,
                               highLimit, nextInclusive);
        return count;
    }

    private static int count12digits(int len, char[] limit, int limitOffset,
                                     boolean highLimit, boolean inclusive) {
        // Code not included because it's too long (exceeds the character limit).
        // But it was just a long string of if-elses anyway.
        // The only trick is to allow "00" if limitOffset > 0.

        return 0;
    }

}
