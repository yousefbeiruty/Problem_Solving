package com.it.yousefl.dataalgo.leetcode;

import com.it.yousefl.dataalgo.trees.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LeetCode {
    /*
     * Input: nums = [2,7,11,15], target = 9
     *
     *
     * */

    public static void main(String[] args) {
        int array[]={3,2,3};
        System.out.println(twoSum(array,6));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static int maxProfit(int [] prices){
        if (prices==null || prices.length==0)
            return 0;

        int profit=0;
        for (int i = 0; i <prices.length-1 ; i++) {

            if (prices[i+1]>prices[i]){
                profit+=prices[i+1]-prices[i];
            }
        }
        return profit;
    }

    public int firstUniqChar(String s) {
        HashMap<Character,Integer>map2=new HashMap<>();

        for(int i=0;i<s.length();i++){
            int count=1;
            if(map2.containsKey(s.charAt(i))){
                map2.put(s.charAt(i),map2.get(s.charAt(i))+count);
            }else
                map2.put(s.charAt(i),count);
        }

        for(int i=0;i<s.length();i++){
            if(map2.containsKey(s.charAt(i))&& map2.get(s.charAt(i))==1)
                return i;
        }
        return -1;
    }



      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            if(nums==null || nums.length==0)
                return null;

            return constructBSTRecursive(nums,0,nums.length-1);
        }

        private TreeNode constructBSTRecursive(int[] nums, int left, int right){
            if(left > right){
                return null;
            }

            int mid=left+(right-left)/2;

            TreeNode current=new TreeNode(nums[mid]);

            current.left=constructBSTRecursive(nums,left,mid-1);
            current.right=constructBSTRecursive(nums,mid+1,right);

            return current;
        }
    }

/**
 * Input: nums = [-10,-3,0,5,9]
 * Output: [0,-3,9,-10,null,5]
 * Explanation: [0,-10,5,null,-3,null,9] is also accepted:
 * */
   //thsis is one way of solution:-
    /**
     * Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
     *
     * Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [3,0,1]
     * Output: 2
     * Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is
     * the missing number in the range since it does not appear in nums.
     */
    public int missingNumber(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int i:nums){
            set.add(i);
        }

        for(int i=0;i<=nums.length;i++){
            if(!set.contains(i)){
                return i;
            }
        }

        return -1;
    }
    //another faster solution:-
    public int missingNumber2(int[] nums) {
        int sum=0;

        for(int i:nums){
            sum+=i;
        }

        int n=nums.length+1;

        return (n*(n-1 )/2)-sum;
    }

    /**
     *  Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.
     *
     * Example 1:
     * Given tree s:
     *
     *      3
     *     / \
     *    4   5
     *   / \
     *  1   2
     * Given tree t:
     *    4
     *   / \
     *  1   2
     * Return true, because t has the same structure and node values with a subtree of s.
     *
     *
     * Example 2:
     * Given tree s:
     *
     *      3
     *     / \
     *    4   5
     *   / \
     *  1   2
     *     /
     *    0
     * Given tree t:
     *    4
     *   / \
     *  1   2
     * Return false
     *
     * */

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class SolutionSubTree {
        /**
         * TODO:-
         *      3         s Tree
         *     / \
         *    4   5
         *   / \
         *  1   2
         *
         *         4    t Tree
         *        / \
         *       1   2
         *
         */
        public boolean isSubtree(TreeNode s, TreeNode t) {
            if(s==null){
                return false;
            }else if(isSameTree(s,t)){
                return true;
            }else{
            /**TODO:- ask different levels in nodes*/
                return isSubtree(s.left,t) || isSubtree(s.right,t);
            }
        }

        public boolean isSameTree(TreeNode s, TreeNode t){
            if(s==null || t==null){
                return s==null && t==null;
            }else if(s.val==t.val){
                return isSameTree(s.left,t.left) && isSameTree(s.right,t.right);
            }else{
                return false;
            }
        }
    }

    /**
     * Q2:-Given two arrays, write a function to compute their intersection.
     *
     * Example 1:
     *
     * Input: nums1 = [1,2,2,1], nums2 = [2,2]
     * Output: [2,2]
     * Example 2:
     *
     * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * Output: [4,9]
     * Note:
     *
     * Each element in the result should appear as many times as it shows in both arrays.
     * The result can be in any order.
     * */

    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer>map=new HashMap<>();

        for(int i:nums1){
            int count=1;
            if(map.containsKey(i)){
                map.put(i,map.get(i)+count);
            }
            else  map.put(i,count);
        }

        ArrayList<Integer> intersection =new ArrayList<>();
        for(int i:nums2){
            if(map.containsKey(i) && map.get(i) > 0){
                intersection.add(i);
                map.put(i, map.get(i)-1);
            }
        }
        int [] result=new int[intersection.size()];
        int index=0;

        for(int i: intersection){
            result[index++]=i;
        }
        return result;
    }

    /**
     *  Q:-   Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: l1 = [1,2,4], l2 = [1,3,4]
     * Output: [1,1,2,3,4,4]
     * Example 2:
     *
     * Input: l1 = [], l2 = []
     * Output: []
     * Example 3:
     *
     * Input: l1 = [], l2 = [0]
     * Output: [0]
     * */


     //TODO:- Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }


        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode dummy=new ListNode(-1);
            ListNode head=dummy;

            while(l1!=null && l2!=null){
                if(l1.val<l2.val){
                    dummy.next=l1;
                    l1=l1.next;
                }else{
                    dummy.next=l2;
                    l2=l2.next;
                }
                dummy=dummy.next;
            }
            if(l1!=null){
                dummy.next=l1;
            }else{
                dummy.next=l2;
            }
            return head.next;

    }

    /**
     *  Q2:-  Write an algorithm to determine if a number n is happy.
     *
     * A happy number is a number defined by the following process:
     *
     * Starting with any positive integer, replace the number by the sum of the squares of its digits.
     * Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
     * Those numbers for which this process ends in 1 are happy.
     * Return true if n is a happy number, and false if not.
     *
     *
     *
     * Example 1:
     *
     * Input: n = 19
     * Output: true
     * Explanation:
     * 12 + 92 = 82
     * 82 + 22 = 68
     * 62 + 82 = 100
     * 12 + 02 + 02 = 1
     * Example 2:
     *
     * Input: n = 2
     * Output: false
     * */

    public boolean isHappy(int n) {
        HashSet<Integer>seen=new HashSet<>();
        while(n != 1){
            int current=n;
            int sum=0;
            while(current != 0){
                sum+=(current % 10) * (current % 10);
                current/=10;
            }

            if(seen.contains(sum)){
                return false;
            }
            seen.add(sum);
            n=sum;
        }
        return true;
    }
}
