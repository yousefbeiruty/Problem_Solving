package com.it.yousefl.dataalgo.da.problemsolvingpaterns

import kotlin.collections.HashMap

fun main() {

    System.out.println(same(arrayOf(1, 2, 1), arrayOf(4,4,1)))
    System.out.println(isAnagram("Anagram".toLowerCase(),"margana".toLowerCase()))

}
//same([1,2,3],[4,1,9])-->true
//same([1,2,3],[1,9])--->false
//same([1,2,1],[4,4,1])--->false
/**
 * What is the “Frequency Counter” pattern?
The Frequency Counter pattern uses an object or set to collect values and the frequency of those values.

This pattern is often used with an array or a string, and allows you to avoid nested
loops (quadratic time complexity O(n²)).

When should I use the Frequency Counter pattern?
The Frequency Counter pattern is most helpful when you have multiple pieces of data that
you want to compare with one another. Let me walk you through an example to see the
Frequency Counter in action.
 * **/
fun same(arr1: Array<Int>, arr2: Array<Int>): Boolean {

    if (arr1.size != arr2.size)
        return false

    val frequencyCounter1 = HashMap<Int, Int>()
    val frequencyCounter2 = HashMap<Int, Int>()

    for (value in arr1) {
        val counter = 1
        if (frequencyCounter1.containsKey(value))
            frequencyCounter1.put(value, counter + 1)
        else
            frequencyCounter1.put(value, counter)
    }

    for (value in arr2) {
        val counter = 1
        if (frequencyCounter2.containsKey(value))
            frequencyCounter2.put(value, counter + 1)
        else
            frequencyCounter2.put(value, counter)
    }

    System.out.println("frequencyCounter1= $frequencyCounter1")
    System.out.println("frequencyCounter2= $frequencyCounter2")

    for (key in frequencyCounter1.keys) {
        if (!(frequencyCounter2.containsKey(key * key))) {
            return false
        }

        if (frequencyCounter2.get(key * key) != frequencyCounter1.get(key)) {
            return false
        }

    }

    return true
}

fun isAnagram(str1:String, str2: String): Boolean {
    System.out.println(str1)
    System.out.println(str2)
    if (str1.length != str2.length)
        return false



    val frequencyCounter1 = HashMap<Char, Int>()
    val frequencyCounter2 = HashMap<Char, Int>()

    for (value in str1){
        val count=1
        System.out.println("frequencyCounter1.containsKey(value)=${frequencyCounter1.containsKey(value)} count=$count")
        if (frequencyCounter1.containsKey(value))
            frequencyCounter1.put(value,count+1)
        else
            frequencyCounter1.put(value,count)
    }

    for (value in str2){
        val count=1
        if (frequencyCounter2.containsKey(value))
            frequencyCounter2.put(value,count+1)
        else
            frequencyCounter2.put(value,count)
    }

    System.out.println(frequencyCounter1)
    System.out.println(frequencyCounter2)

    for (key in frequencyCounter1.keys) {
        if (!(frequencyCounter2.containsKey(key))) {
            return false
        }

        if (frequencyCounter2.get(key) != frequencyCounter1.get(key)) {
            return false
        }

    }

    return true
}

