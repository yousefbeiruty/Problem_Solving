package com.it.yousefl.dataalgo.binaryheaps

import com.it.yousefl.dataalgo.searchalgoriths.binarySearch
import com.it.yousefl.dataalgo.sortingalgorithms.noSwap
import com.it.yousefl.dataalgo.sortingalgorithms.swap
import kotlin.math.floor

fun main() {

    val heap=MaxHeap()
    heap.insert(41)
    heap.insert(39)
    heap.insert(33)
    heap.insert(18)
    heap.insert(27)
    heap.insert(12)
    System.out.println(heap.insert(55))//41 , 39 , 33 , 18 , 27 , 12 ,55
    System.out.println(heap.extractMax())//[41, 39 , 33 , 18 , 27 , 12]

}

class MaxHeap{
    val values=ArrayList<Int>()

    fun insert(value:Int):ArrayList<Int>{
        values.add(value)
        bubbleUp();
        return values
    }

    fun bubbleUp() {
     var index=values.size-1
     val element=values[index]

        while (index > 0){
            val parentIndex= Math.floor(((index-1)/2).toDouble())
            if ( element <= values.get(parentIndex.toInt())) break
            val temp=values[parentIndex.toInt()]
            values[parentIndex.toInt()]=element
            values[index]=temp
            index=parentIndex.toInt()
        }
      //TODO:-[ 41 , 39 , 33 , 18 , 27 , 12  ,55]
      //        0    1    2    3    4    5
      //  [ 41 , 39 , 55 , 18 , 27 , 12  ,33]  swap because 55 child is greater than 33 parent
      //                                         and this is a max binary heap
     //  [ 55 , 39 , 41 , 18 , 27 , 12  ,33]    swap because 55 child is greater than 41 parent
     //                                          and this is a max binary heap
    }

    fun extractMax():ArrayList<Int>{
        val max=values[0]
        val end=values[values.size-1]
        values.removeAt(values.size-1)
        if (values.size > 0){
            values[0]=end
            //Trickle down
            sinkDown()
        }
        return values
    }
     //        0     1    2
    //TODO:- [ 33 , 39 , 41 , 18 , 27 ,12]
    // thsis function will extract or remove the root value of the heap and then will Trickle down
    fun sinkDown(){
       var index=0
       val length=values.size
       val element=values[0]

         while (true){
             val leftChildIndex=2*index+1
             val rightChildIndex=2*index+2
             var rightChild:Int?=null
             var leftChild:Int?=null
             var swap:Int?=null

             if (leftChildIndex < length){
                 leftChild=values[leftChildIndex]
                 if (leftChild > element){
                     swap=leftChildIndex
                 }
             }
             if (rightChildIndex < length){
                 rightChild=values[rightChildIndex]
                 // [ 33 , 41 , 39 , 18 , 27 ,12] it could be like this and keep comparing that's wrong
                 if ((swap==null && rightChild > element )
                 //This condition is to handle if the right and the left is larger than the element
                         ||(swap!=null && rightChild > leftChild!!)){
                     swap=rightChildIndex
                 }
             }

             if (swap==null)break
             values[index]=values[swap]
             values[swap]=element
             index=swap
         }
    }
//      [ 55 , 39 , 41 , 18 , 27 , 12  ,33]
    //[39 , 41 , 18 , 27 , 12  ,33]

    // [39 , 41 , 18 , 27 , 12  ,33]

    }


