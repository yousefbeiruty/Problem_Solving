package com.it.yousefl.dataalgo.da.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Pasckal {

    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    /**
     * Q:-Pascal Triangle.                                                                                                                                                                    Given an integer numRows, return the first numRows of Pascal's triangle.
     *
     * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
     *
     *
     *
     *
     * Example 1:
     *
     * Input: numRows = 5
     * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
     * Example 2:
     *
     * Input: numRows = 1
     * Output: [[1]]
     * */

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>>triangle=new ArrayList<>();

        if(numRows==0)return triangle;

        List<Integer>first_row=new ArrayList<>();
        first_row.add(1);
        triangle.add(first_row);

        for(int i=1;i<numRows;i++){//i=3
            List<Integer>prev_row=triangle.get(i-1); //3-1=2
            List<Integer>row=new ArrayList<>();

            row.add(1);

            for(int j=1;j<i;j++){//1
                row.add(prev_row.get(j-1)+prev_row.get(j));//(0)+1
            }
            row.add(1);
            triangle.add(row);
        }
        return triangle; //[[1],[1,1],[1,2,1],[1,3 ...].....]
    }
}
