package com.it.yousefl.dataalgo.searchalgoriths

fun main() {
    val array = ArrayList<Int>()
    array.add(2)
    array.add(5)
    array.add(6)
    array.add(9)
    array.add(13)
    array.add(15)
    array.add(28)
    array.add(30)
    System.out.println(binarySearch(array, array.size - 1, 0, 28))
}

/**------------------Linear Search O(n)----------------*/

fun linearSearch(arrayList: ArrayList<Int>, value: Int): Int {
    if (arrayList.size == 0)
        return -1
    arrayList.map { if (it == value) return arrayList.indexOf(it) }
    return -1;
}

/**------------------Binary Search O(log n)----------------*/
/**Note:-To use binary search the list need to be sorted**/
// Returns index of x if it is present in arr[l..
// r], else return -1
fun binarySearch(arrayList: ArrayList<Int>, end: Int, start: Int, value: Int): Int {
    if (arrayList.size == 0) return -1
//  0  1   2   3   4    5    6     7
//[ 2, 5 , 6 , 9 , 13 , 15 , 28 , 30 ]
//  s          m                   e

//  0  1   2   3   4    5    6    7
//[ 2, 5 , 6 , 9 , 13 , 15 , 28 , 30 ]
//                  s    m         e

//  0  1   2   3   4    5    6    7
//[ 2, 5 , 6 , 9 , 13 , 15 , 28 , 30 ]
//                           sm    e
    if (end >= start) {
        val midle = start + (end - start) / 2
        // If the element is present at the
        // middle itself
        if (arrayList.get(midle) == value)
            return midle
        // If element is smaller than mid, then
        // it can only be present in left subarray
        else if (value < arrayList.get(midle))
            binarySearch(arrayList, midle - 1, start, value)


        // Else the element can only be present
        // in right subarray
        return binarySearch(arrayList, end, midle + 1, value);
    }
    return -1
}



/**-----------------Naive String search-------------*/
/**Ex:-Search for a substring in a larger string:-
 * "harold said haha in hamburg"
 * serach for "haha"
 *
 * */
