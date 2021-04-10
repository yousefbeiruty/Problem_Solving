package com.it.yousefl.dataalgo.da.problemsolvingpaterns;

import java.util.ArrayList;
import java.util.HashMap;

public class SlidePatern {
/**
 * Sliding Window Pattern:-
 * This pattern involves creating a window which can either be an array
 * or number from one position to another Depending on a certain condition
 * ,The window either increases or closes(and a new window is created).
 *
 *TODO :-Very useful for keeping track of a subset of data in an array/string etc.
 */
    /**
     * Q:-Write a function that called maxSubArraySum which accepts an array of integers
     * and a number called n.The function should calculate the maximum sum of n
     * consecutive elements in the array.
     *
     * **/
//maxSubArraySum([1,2,5,2,8,1,5],2)-->10
//maxSubArraySum([1,2,5,2,8,1,5],4)-->17
//maxSubArraySum([4,2,1,6],1)-->6
//maxSubArraySum([],4)-->null
    public static void main(String[] args) {

        ArrayList<Integer> arrayList=new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);

        System.out.println("maxSubArraySum= "+maxSubArraySum(arrayList,2));

        System.out.println("sameFrequency= "+sameFrequency(3589578,5879385));

    }
    //0 1 2 3
    //[1,2,3,4]
    public static int  maxSubArraySum(ArrayList<Integer>array,int num){
        int maxSum=0;
        int tempSum=0;

        if (array.size()<num) return 0;

        for(int i=0;i<num;i++){
            //max=0+1=1
            //max=1+2=3
            maxSum+= array.get(i);
            System.out.println("count loop i=" +i);
            System.out.println("maxSum= "+" ----> "+maxSum);
        }
        //temp=3
        tempSum=maxSum;

        //i=2  2<4
        //i=3 3<4
        for (int i=num;i<array.size();i++){
            //tem=3-1+3=5
            //tem=5-2+4=7
            tempSum=tempSum-array.get(i-num)+array.get(i);
            //max=Math.max(3,5)
            //max=Math.max(5,7)
            maxSum=Math.max(maxSum,tempSum);
        }

        return maxSum;
    }

    //123,12
    public static boolean sameFrequency(int num1, int num2) {

        HashMap<Integer, Integer> hashMap1 = new HashMap<>();
        HashMap<Integer, Integer> hashMap2 = new HashMap<>();

        while (num1 > 0) {
            int count = 1;
            if (hashMap1.containsKey(num1 % 10)){
                hashMap1.put(num1 % 10, hashMap1.get(num1 % 10)+count);
            }else {
                hashMap1.put(num1 % 10, count);
            }
            System.out.println("hashMap1="+hashMap1);
            num1 = num1 / 10;
            System.out.println("num1 = num1 / 10="+num1);
        }

        while (num2 > 0) {
            int count = 1;
            if (hashMap2.containsKey(num2 % 10)){
                hashMap2.put(num2 % 10, hashMap2.get(num2 % 10)+count);
            }else {
                hashMap2.put(num2 % 10, count);
            }
            System.out.println("hashMap2="+hashMap2);
            num2 = num2 / 10;
            System.out.println("num2 = num2 / 10="+num2);
        }

        for (int key : hashMap1.keySet()){

            if (!(hashMap2.containsKey(key) && hashMap2.get(key).equals(hashMap1.get(key)))) {
                return false;
            }
        }
        System.out.println("hashMap1 ="+hashMap1);
        System.out.println("hashMap2 ="+hashMap2);
        return true;
    }


    public static boolean areThereDuplicates(ArrayList<Integer> arrayList) {

        HashMap<Object, Object> hashMap = new HashMap<>();

        for (int i = 0; i < arrayList.size(); i++) {
            if (hashMap.containsKey(arrayList.get(i))) {
                return true;
            }
            hashMap.put(arrayList.get(i), i);
        }
        return false;
    }

    //  i               j
    //[ 1 , 2 , 3 , 4 , 5 ]
    public static boolean areThereDuplicatesCounter(ArrayList<Integer> arrayList){

        int left=0;
        int right=arrayList.size()-1;

        while (right>0 && left<right){
            if (arrayList.get(left)==arrayList.get(right)){
                return true;
            }else if (left<right){
                left++;
            }else {
                right --;
            }

        }
        return false;
    }

}
