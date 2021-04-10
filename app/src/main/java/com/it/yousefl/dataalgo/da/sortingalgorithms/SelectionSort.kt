package com.it.yousefl.dataalgo.da.sortingalgorithms

import java.util.*

/**------------------Selection Sort ------------------*/
fun main() {
    val arrayList = ArrayList<Int>()
    arrayList.add(34)
    arrayList.add(22)
    arrayList.add(10)
    arrayList.add(19)
    arrayList.add(17)
    println(shellSort(arrayList))
}

//selectionSort([ 34 , 22 , 10 , 19 , 17])
//i , j , lowest
//0 , 1 , 1
// 0 , 2 , 2
//  0 , 3 , 2
// 0 , 4 , 2

//selectionSort([ 34 , 22 , 10 , 19 , 17])
//i , j , lowest
//0 , 1 , 1
// 0 , 2 , 2
//  0 , 3 , 2
// 0 , 4 , 2
fun shellSort(arrayList: ArrayList<Int>): ArrayList<Int>? {
    for (i in arrayList.indices) {
        var small = i
        for (j in i + 1 until arrayList.size) {
            if (arrayList[j] < arrayList[small]) {
                small = j
            }
        }
        if (i != small) swapSelection(arrayList, i, small) //
        println(arrayList)
    }
    return arrayList
}

fun swapSelection(arrayList: ArrayList<Int>, large: Int, small: Int) {
    val temp = arrayList[small]
    arrayList[small] = arrayList[large]
    arrayList[large] = temp
}