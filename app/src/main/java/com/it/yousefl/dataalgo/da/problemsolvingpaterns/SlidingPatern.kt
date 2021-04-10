package com.it.yousefl.dataalgo.da.problemsolvingpaterns

fun main() {

}

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
//fun maxSubArraySum(array: Array<Int>, num: Int):Int? {
//var maxSum=0
//var tempSum=0
//
//    if (array.size)
//
//    return 0
//}