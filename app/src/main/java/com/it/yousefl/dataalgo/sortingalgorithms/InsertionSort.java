package com.it.yousefl.dataalgo.sortingalgorithms;

import java.util.ArrayList;

public class InsertionSort {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(9);
        arrayList.add(76);
        arrayList.add(0);
        insertionSort(arrayList);
    }

    /**
     * ---------------Insertion Sort O(n^2)-------------
     * Builds up the sort by gradually creating a larger left half which is
     * always sorted
     */
//[ 2 , 1 , 9 , 76 , 4 ]
//              j    i
//[ 1 , 2 , 9 , 76 , 0 ]
//[ 1 , 2 , 9 , 76 , 76 ] 0
//[ 1 , 2 , 9 , 9 , 76 ] 0
//[ 1 , 2 , 2 , 9 , 76 ] 0
//[ 1 , 1 , 2 , 9 , 76 ] 0
//[ 0 , 1 , 2 , 9 , 76 ] 0
    public static void insertionSort(ArrayList<Integer> arrayList) {

        for (int i = 1; i < arrayList.size(); i++) {
            int currentVal = arrayList.get(i);//2
                                              //9
                                              //76
                                              // 0
            int j = i - 1;//1-1=0
                          //2-1=1
                         //3-1=2
                        //4-1=3
            //     0>=0   &&   1>2
            //     1>=0   &&     2>9
           //      2>=0   &&     9>76
           //      3>=0   &&     76>0
            while (j >= 0 && arrayList.get(j) > currentVal) {
                arrayList.set(j+1,arrayList.get(j));//array[3+1]=array[3]
                                                    //array[4]=76
                j--;//3
            }                             // array[0+1]
            arrayList.set(j+1,currentVal);//array[1]=2
                                         //array[1+1]
                                         //array[2]=9
                                        //array[2+1]
                                       //array[3]=76

            System.out.println(arrayList);
        }
    }

}


