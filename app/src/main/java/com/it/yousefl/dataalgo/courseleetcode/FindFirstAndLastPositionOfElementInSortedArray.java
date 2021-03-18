package com.it.yousefl.dataalgo.courseleetcode;

public class FindFirstAndLastPositionOfElementInSortedArray {

    public static void main(String[] args) {

    }

    /**TODO:-Difficulty:-Medium
     *https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
     * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
     *
     * If target is not found in the array, return [-1, -1].
     *
     * Follow up: Could you write an algorithm with O(log n) runtime complexity?
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [5,7,7,8,8,10], target = 8
     * Output: [3,4]
     * Example 2:
     *
     * Input: nums = [5,7,7,8,8,10], target = 6
     * Output: [-1,-1]
     * Example 3:
     *
     * Input: nums = [], target = 0
     * Output: [-1,-1]
     * */
    public int[] searchRange(int[] nums, int target) {
        int[] results=new int[2];
        results[0]=findSatringIndex(nums,target);
        results[1]=findEndingIndex(nums,target);
        return results;
    }

    public int findSatringIndex(int[]nums,int target){
        int index=-1;

        int start=0;
        int end=nums.length-1;

        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]>=target){
                end=mid-1;
            }else{
                start=mid+1;
            }
            if(nums[mid]==target){
                index=mid;
            }
        }

        return index;
    }
    public int findEndingIndex(int[]nums,int target){
        int index=-1;

        int start=0;
        int end=nums.length-1;

        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]<=target){
                start=mid+1;
            }else{
                end=mid-1;
            }
            if(nums[mid]==target){
                index=mid;
            }
        }
        return index;
    }
}
