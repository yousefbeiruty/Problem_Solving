package com.it.yousefl.dataalgo.da.leetcode;

import java.util.ArrayList;

public class ReverseString {
    public static void main(String[] args) {
        ArrayList<Character> arrayList = new ArrayList<>();
        arrayList.add('s');
        arrayList.add('a');
        arrayList.add('b');
        arrayList.add('c');
        reverseString(arrayList);

    }

    public static ArrayList<Character> reverseString(ArrayList<Character> s) {
        ArrayList<Character> arrayList = new ArrayList<>();
        for (int i = s.size() - 1; i >= 0; i--) {
            arrayList.add(s.get(i));
        }
        System.out.println(arrayList);


        return arrayList;
    }


}
