package com.sudhar.examples;


// https://leetcode.com/problems/longest-palindrome/solution/

//Input: s = "abccccdd"
//        Output: 7
//        Explanation:
//        One longest palindrome that can be built is "dccaccd", whose length is 7.

//Input: s = "bb"
//        Output: 2
public class LongestPallingdrome {

    public static void main(String[] args) {
        LongestPallingdrome longestPallingdrome = new LongestPallingdrome();

        System.out.println(longestPallingdrome.longestPalindrome("abccccdd"));
    }
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        int length = 0;
        for(char c: s.toCharArray()){
            if(++count[c] == 2){
                length += 2;
                count[c] = 0;
            }
        }
        return (length == s.length())? length: length+1;
    }
}
