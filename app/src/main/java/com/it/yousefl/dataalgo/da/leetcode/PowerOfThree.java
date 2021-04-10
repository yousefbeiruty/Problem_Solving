package com.it.yousefl.dataalgo.da.leetcode;

public class PowerOfThree {
    public static void main(String[] args) {

    }

    /**
     * Given an integer n, return true if it is a power of three. Otherwise, return false.
     * <p>
     * An integer n is a power of three, if there exists an integer x such that n == 3x.
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: n = 27
     * Output: true
     * Example 2:
     * <p>
     * Input: n = 0
     * Output: false
     * Example 3:
     * <p>
     * Input: n = 9
     * Output: true
     * Example 4:
     * <p>
     * Input: n = 45
     * Output: false
     */
    public boolean isPowerOfThree(int n) {
        long i = 1;
        while (i < n) {
            i *= 3;
        }
        return i == n;
    }
}
