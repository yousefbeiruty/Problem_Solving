package com.it.yousefl.dataalgo.da.leetcode;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class TestLeet {
    static List<Integer> arr=new ArrayList<>();//{1,2,3,4,5};
    static List<Integer> arr2=new ArrayList<>();//{1,4,9,16,25};
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main(String[] args) {
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);

        PriorityQueue<Integer>priorityQueue=new PriorityQueue<>();


        priorityQueue.poll();

        arr2.add(1);
        arr2.add(4);
        arr2.add(9);
        arr2.add(16);
        arr2.add(25);
//
//        System.out.println("same= "+ same());
//
//        System.out.println("----------------");
//        System.out.println("same2= "+ same2());



   //   System.out.println(Arrays.toString(sumZero(new int[]{-3, -2, -1, 0, 1, 2, 3})));

       System.out.println(maxSum2(new int[]{1,2,5,2,8,1,5},2));
    }

    // Returns maximum sum in
    // a subarray of size k.
    static int maxSum(int arr[], int k) {

        // ({1,2,5,2,8,1,5},2)
        int n=arr.length;//7
        // n must be greater
        if (n < k) {// 7<2
            System.out.println("Invalid");
            return -1;
        }

        // Compute sum of first window of size k
        int max_sum = 0;
        for (int i = 0; i < k; i++)//k=2 i=2
            max_sum += arr[i];//3

        // Compute sums of remaining windows by
        // removing first element of previous
        // window and adding last element of
        // current window.
        int window_sum = max_sum;//3
        for (int i = k; i < n; i++) {//i=6
            window_sum += arr[i] - arr[i - k];//9-5+8
            max_sum = Math.max(max_sum, window_sum);//(10,9)=10
        }


        return max_sum;
    }

   public static int maxSum2(int[]nums,int k){
        //{1,2,5,2,8,1,5},2
       if(nums.length<k){
           return -1;
       }
       int maxSum=0;

       for(int i=0;i<k;i++)
           maxSum+=nums[i];

       int windowsSum=maxSum;

       for(int j=k;j<nums.length;j++){
           windowsSum+=nums[j]-nums[j-k];
           maxSum=Math.max(maxSum,windowsSum);
       }
       return maxSum;
   }

    public static int[] sumZero(int[]nums){
        int i=0;
        int j=nums.length-1;
        int[] sums=new int[2];
        while (i<j){
            int sum=nums[i]+nums[j];
            if (sum==0){
                sums[0]=nums[i];
                sums[1]=nums[j];
                return sums;
            }else if (sum>0){
                j--;
            }else {
                i++;
            }
        }
        return sums;
    }

    public static boolean same(){
        //O(n^2)
        for (int i=0;i<arr.size();i++){
            int index=arr2.indexOf(arr.get(i)^2);//1^2
            if(index==-1){
                return false;
            }
            arr2.remove(index);
        }

        return  true;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static boolean same2(){
        //Frequency Counters Solution O(n)
        HashMap<Integer,Integer>map1=new HashMap<>();
        HashMap<Integer,Integer>map2=new HashMap<>();

        for (int i=0;i<arr.size();i++){
            if(map1.containsKey(arr.get(i))){
                map1.put(arr.get(i),map1.get(arr.get(i))+1);
            }else
                map1.put(arr.get(i),map1.getOrDefault(arr.get(i),1));
        }

        for (int i=0;i<arr2.size();i++){
            if(map2.containsKey(arr2.get(i))){
                map2.put(arr2.get(i),map2.get(arr.get(i))+1);
            }else
                map2.put(arr2.get(i),map2.getOrDefault(arr2.get(i),1));
        }

        System.out.println(map1);
        System.out.println(map2);
        for (int key:map1.keySet()){
            if(!map2.containsKey(key*key)){
                return false;
            }
            if (map1.get(key)!= map2.get(key*key)){
                return false;
            }
        }

        return true;
    }

}
