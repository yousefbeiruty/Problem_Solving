package com.it.yousefl.dataalgo.problemsolvingpaterns;

import java.util.ArrayList;

public class DivideAndCoquerPatern {

    /**
     * Divide and Conquer Pattern:-This pattern involves dividing a data set into smaller chunks and then
     * repeating a process with a subset of data.
     *
     * TODO:-  This pattern can tremendously decrease
     *              time complexity
     *
     * */


    /**
     * EX:-Given a sorted array of integers, write a function called search,That accepts a value and return
     * the index where the value passed to the function is located. if the value is not found , return -1
     *
     * search([1,2,3,4,5,6],4)---> 3
     * search([1,2,3,4,5,6],6)---> 5
     * search([1,2,3,4,5,6],11)---> -1
     * */

    public static int linearSearch(ArrayList<Integer> array, int val){
        for (int i=0;i<array.size();i++) {
            if (array.get(i)==val)
                return i;
        }
        return -1;
        //TODO:- Time Complexity O(n)
    }

    //0 1 2 3 4 5
    //[1,2,3,4,5,6],4
    public static  int binarySearch(ArrayList<Integer>array,int val){
        int min=0;
        int max=array.size()-1;//6-1=5

        //0<=5
        while (min<=max){
            //middle=(int) Math.floor((0+5)/2)=3
            int middle= (int) Math.floor((min+max)/2);
            //current_element=array.get(3)=4
            int current_element=array.get(middle);

            System.out.println("middle= "+middle);
            //4<4
            if (array.get(middle)<val) {
                middle = middle + 1;//middle=4+1=5
                System.out.println("array.get(middle)<val ---> middle= "+middle);
            }else if (array.get(middle)>val){//4>4
                max=middle-1;
                System.out.println("array.get(middle)>val ---> middle= "+middle);
            }else {
                return middle;//middle=4
                // System.out.println("else middle= "+middle);
            }
        }
        return -1;
        //TODO:- Time Complexity O(log n)
    }

}
