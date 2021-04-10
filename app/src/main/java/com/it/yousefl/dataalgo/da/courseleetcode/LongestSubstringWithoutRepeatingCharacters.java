package com.it.yousefl.dataalgo.da.courseleetcode;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {

    }
    /**TODO:-Difficulty:Medium
     * Q:-https://leetcode.com/problems/longest-substring-without-repeating-characters/
     * Given a string s, find the length of the longest substring without repeating characters.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", with the length of 3.
     * Example 2:
     *
     * Input: s = "bbbbb"
     * Output: 1
     * Explanation: The answer is "b", with the length of 1.
     * Example 3:
     *
     * Input: s = "pwwkew"
     * Output: 3
     * Explanation: The answer is "wke", with the length of 3.
     * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
     * Example 4:
     *
     * Input: s = ""
     * Output: 0
     *
     * */

    public int lengthOfLongestSubstring(String s) {
        int left=0;
        int right=0;
        int ans=0;
        HashMap<Character,Integer>m=new HashMap<>();

        while (left<s.length() && right<s.length()){
            if(m.containsKey(s.charAt(right))){
                left=Math.max(left,m.get(s.charAt(right))+1);
            }
            m.put(s.charAt(right),right);
            ans=Math.max(ans,right-left+1);
            right++;
        }
        return ans;
    }

    //TODO:-In my openion i think this is a less complicated more readable solution
    public int lengthOfLongestSubstring2(String s) {
        int a_pointer=0;
        int b_pointer=0;
        int max=0;
        HashSet<Character> set=new HashSet<>();
        while(b_pointer<s.length()){
            if(!set.contains(s.charAt(b_pointer))){
                set.add(s.charAt(b_pointer));
                b_pointer++;
                max=Math.max(max,set.size());
            }else{
                set.remove(s.charAt(a_pointer));
                a_pointer++;
            }
        }
        return max;
    }
}

