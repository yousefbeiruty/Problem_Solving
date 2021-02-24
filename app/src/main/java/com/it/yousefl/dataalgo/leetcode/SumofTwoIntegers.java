package com.it.yousefl.dataalgo.leetcode;

public class SumofTwoIntegers {

    public static void main(String[] args) {
      System.out.println(getSumRecursion(5,5));
    }
        //TODO:-Without using + - * / (Bit Shifting) (Bit manipulation)
        /**
         *    13---->5----->1----------->0
         *     4     3      2      1     0
         *     0     1      1      0     1
         *    ---   ----   ----   ---   ---
         *    4^2   3^2    2^2    1^2   0^2   ----->8+4+1=13
         *    16
         * **/
        public static int getSumRecursion(int a, int b) {
            return b == 0 ? a : getSumRecursion(a ^ b, (a & b) << 1);
        }
   // The above code may be rewritten to make it more readable.
        public static int getSumIteration(int a, int b) {
            while (b != 0) {
                int c = ((a & b) << 1);
                a ^= b;
                b = c;
            }
            return a;
        }
   /** c stands for the carry bit of adding two integers. The sum of two integers can be decomposed
    into a summation bit (a & b) and a carry bit (a ^ b). The << 1 is to set the carry bit to the
    correct bit. The above process is repeated until no carry (c, stored in b, becomes 0).
    Then the sum is stored in a.**/
}
