package com.it.yousefl.dataalgo.da.leetcode;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.HashMap;

public class MajorityElement {

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main(String[] args) {

        int array[]={6,53,53,96,45,79,53,58,53,90,40,53,53,1,53,53,89,53,33,27,53,53,84,42,53,53,87,51,66,53,28,53,53,53,50,39,36,48,19,74,38,53,42,53,99,53,80,53,53,53,53,96,78,52,24,53,53,53,53,64,10,53,53,53,53,82,53,53,53,22,53,53,67,53,53,53,53,53,67,53,19,99,53,53,21,53,69,53,53,53,52,53,96,53,53,51,81,62,4,6};
        System.out.println(majorityElement(array));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static int majorityElement(int[] nums) {
        if (nums.length<=1)
            return nums[0];
        HashMap<Integer,Integer> map=new  HashMap();


        for(int i=0;i<nums.length;i++){
            int count=1;
            if(map.containsKey(nums[i]) && map.get(nums[i])+1 > nums.length/2){
              return nums[i];
            }else{
                map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            }
        }

        return 0;
    }
}
