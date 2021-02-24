package com.it.yousefl.dataalgo.leetcode;

import java.util.HashMap;

public class SingleNumber {

    public static void main(String[] args) {

       int nums[] = {4,1,2,1,2};
        System.out.println("Output: "+singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        HashMap<Integer,Integer> map=new  HashMap<Integer,Integer>();

        for(int i=0;i<=nums.length-1;i++){
            int count=1;
            if(map.containsKey(nums[i])){
                map.put(i,++count);
            }else
                map.put(i,count);
        }
        for(int j=0;j<=map.size();j++){
            if (map.get(nums[j])!=null){
            if(map.get(nums[j])==1){
                return nums[j];
            }
            }
        }

        return 0;
    }
}
