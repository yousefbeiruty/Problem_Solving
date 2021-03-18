package com.it.yousefl.dataalgo.courseleetcode;

public class MoveZeroz {
    public static void main(String[] args) {

        int[]arr={0,1,0,3,12};
        moveZero(arr);
    }
    /**TODO:-Difficulty : Easy
     * Q:-Given an array nums, write a function to move all 0's to the end of it while
     * maintaining the relative order of the non-zero elements.

     Example:

     Input: [0,1,0,3,12]
     Output: [1,3,12,0,0]
     Note:

     You must do this in-place without making a copy of the array.
     Minimize the total number of operations.
     *
     * */
    public static void moveZero(int[]nums){
        int j=0;
        for (int num:nums){
            if(num!=0){
                nums[j]=num;
                j++;
            }
        }
        for (int a=j;a<nums.length;a++) {
            nums[a]=0;
        }
    }
}
