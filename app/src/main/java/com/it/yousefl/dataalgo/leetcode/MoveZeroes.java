package com.it.yousefl.dataalgo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MoveZeroes {

    public static void main(String[] args) {

        int nums[]={0,1,0,3,12};
       // System.out.println(moveZeroes(nums));//[1,3,12,0,0]
    }
    public static void moveZeroes(int[] nums) {
      int index=0;
        for (int i=0;i<nums.length; i++) {
            if(nums[i]!=0) {
              nums[index++]=nums[i];
            }
        }
        for (int i=index;i<nums.length; i++) {
                nums[i]=0;
        }
    }
}
