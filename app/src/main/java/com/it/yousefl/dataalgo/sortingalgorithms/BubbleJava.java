package com.it.yousefl.dataalgo.sortingalgorithms;

import java.util.ArrayList;

public class BubbleJava {

    public static void main(String[] args) {
        ArrayList<Integer>arrayList=new ArrayList<>();
        arrayList.add(10);
        arrayList.add(3);
        arrayList.add(41);
        arrayList.add(2);
        System.out.println(bubbleSort(arrayList));
    }
    //[ 10 , 3 , 41 , 2]
    public static ArrayList<Integer> bubbleSort( ArrayList<Integer> array) {
        for (int i=0;i< array.size()-1;i++){
            System.out.println(array);
            for (int j=0;j< array.size()-i-1;j++) {
                if (array.get(j) > array.get(j+1)) {
                    swap(array, j, j+1);
                }
            }
        }
        return array;
    }

    public static void swap(ArrayList<Integer>array ,int greater,int small){
        int temp= array.get(greater);
        array.set(greater, array.get(small));
        array.set(small, temp);
    }
}
