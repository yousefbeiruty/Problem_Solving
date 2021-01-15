package com.it.yousefl.dataalgo.problemsolvingpaterns

fun main() {
    /**
     * Multiple Pointers Pattern:-
     * What is the “Multiple Pointers Pattern ” pattern?
     * Creating pointers or values that correspond to an index or position and move towards the beginning,
     * end or middle based on certain condition very efficient for solving problems with minimal space
     * complexity as well.
     * */
  //  System.out.println(sumZero(arrayOf(-1,-2,-3,0,1,2,3)))

    System.out.println(countUniqueValues(arrayOf(-1,-2,-1,-1,0,1)))

}

/** Write a function called sumZero which accepts a sorted array of integers.
 *  TODO The functions should find the first pair where the sum is 0.
 *  Return an array that includes both values that sum to zero or undefined if a pair does not exist.
 *
 * //sumZero([-3,-2,-1,0,1,2,3])-->[-3,3]
 * //sumZero([-2,0,1,3])-->undefined or null
 * //sumZero([1,2,3])-->undefined or null
 **/
fun sumZero(array: Array<Int>): ArrayList<Int>? {

        var left = 0
        var right = array.size - 1

        while (left<right){
            val sum=array[left] + array[right]

            if (sum == 0) {
                return arrayListOf<Int>(array[left],array[right])
                break
            } else if (sum>0) {
                right--;
            }  else{
                left++;
            }
        }

    return null
}






/**Question:-
 * count unique values implement a function called countUniqueValues,which accepts a sorted array, and counts
 * the unique values in the array.There can be negative numbers in the array,but it will always be sorted.
 * */

fun countUniqueValues(array: Array<Int>): Int{
//    //this way works just with sorted array
//    var i=0
//
//    for (value in 1 until array.size) {
//        //apply your logic
//        if (array[i]!=value){
//            i++
//            array[i]=value
//        }
//    }
//
// return i+1
//this is one way using hashmap:-
    val hashmap=HashMap<Int,Int>()
    array.map {
        if (!hashmap.containsKey(it))
            hashmap.put(it,it)
    }

    System.out.println(hashmap)
    return hashmap.size

}


