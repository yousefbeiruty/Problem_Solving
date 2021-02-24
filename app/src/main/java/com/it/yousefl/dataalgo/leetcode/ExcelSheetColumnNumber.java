package com.it.yousefl.dataalgo.leetcode;

public class ExcelSheetColumnNumber {

    public static void main(String[] args) {

        System.out.println(excelSheetColumnNumber("AA"));
    }

    public static int excelSheetColumnNumber(String s){
        int result=0;
        for (int i=0;i<s.length() ; i++) {
                int d = s.charAt(i) - 'A' + 1;     //A-A + 0^26
                result=result*26+d;
            }

        return result;
    }
}
