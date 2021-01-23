package com.it.yousefl.dataalgo.sortingalgorithms;

import java.util.ArrayList;

public class SelectionSort {

    /**
     * ----------------Selection Sort -------------------*
     * <p>
     * it's similar to bubble sort, but instead of first placing large values into sorted position,it
     * places small values into sorted positions.
     */

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(34);
        arrayList.add(22);
        arrayList.add(10);
        arrayList.add(19);
        arrayList.add(17);
        System.out.println(shellSort(arrayList));
    }

    //selectionSort([ 34 , 22 , 10 , 19 , 17])
    //i , j , lowest
    //0 , 1 , 1
    // 0 , 2 , 2
    //  0 , 3 , 2
    // 0 , 4 , 2

    public static ArrayList<Integer> shellSort(ArrayList<Integer> arrayList) {


        for (int i = 0; i < arrayList.size(); i++) {
            int small = i;

            for (int j = i + 1; j < arrayList.size(); j++) {
                if (arrayList.get(j) < arrayList.get(small)) {
                    small = j;
                }
            }
            if (i!=small)
                swap(arrayList, i, small);//
            System.out.println(arrayList);
        }

        return arrayList;
    }

    public static void swap(ArrayList<Integer> arrayList, int large, int small) {
        int temp = arrayList.get(small);
        arrayList.set(small, arrayList.get(large));
        arrayList.set(large, temp);
    }
}
