package com.it.yousefl.dataalgo.sortingalgorithms

import java.util.*

/**------------------Bubble Sort O(n^2)------------------*/
fun main() {
    bubbleSort(arrayListOf(8, 1, 2, 3,4,5,6,7))
//System.out.println(bubbleSort(arrayListOf(10 , 3 , 41 , 2)))
}
var noSwap=false
//[ 10 , 3 , 41 , 2]
fun bubbleSort(array: ArrayList<Int>): ArrayList<Int>? {

    for (i in 0 until array.size - 1) {
        println(array)
        noSwap=true
        for (j in 0 until array.size - i - 1) {
            if (array[j] > array[j + 1]) {
                swap(array, j, j + 1)
            }
        }
        if (noSwap)
            break
    }
    return array
}

fun swap(array: ArrayList<Int>, greater: Int, small: Int) {
    val temp = array[greater]
    array[greater] = array[small]
    array[small] = temp
    noSwap=false
}

