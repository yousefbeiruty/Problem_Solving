package com.it.yousefl.dataalgo.leetcode;

import java.util.HashMap;

public class ImplementstrStr {

    public static void main(String[] args) {

    }

    /**
     * Implement strStr().
     *
     * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
     *
     * Clarification:
     *
     * What should we return when needle is an empty string? This is a great question to ask during an interview.
     *
     * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
     *
     *
     *
     * Example 1:
     *
     * Input: haystack = "hello", needle = "ll"
     * Output: 2
     * Example 2:
     *
     * Input: haystack = "aaaaa", needle = "bba"
     * Output: -1
     * Example 3:
     *
     * Input: haystack = "", needle = ""
     * Output: 0
     *
     * */

    public int strStr(String haystack, String needle) {
        // haystack = "hello", needle = "ll"
        if(needle.isEmpty()) return 0;

        int m=haystack.length();//5
        int n=needle.length();//2

        if(m<n){
            return -1;
        }
        //              3
        for(int i=0;i<=m-n;i++){//i=2
            int j;//j=2
            for(j=0;j<n;++j){     //3                  1
                if(haystack.charAt(i+j)!=needle.charAt(j))//l!=l
                    break;
            }
            if(j==n){
                return i;
            }
        }
        return -1;
    }
}
