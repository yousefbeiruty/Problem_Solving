package com.it.yousefl.dataalgo.hackerrank

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val arr = intArrayOf(1, 1, 3, 1, 2, 1, 3, 3, 3, 3)

    System.out.println(sockMerchant(10, arr))

    val consoleInput = BufferedReader(InputStreamReader(System.`in`))
}

// Complete the sockMerchant function below.
fun sockMerchant(n: Int, arr: IntArray): Int {
    if (n == 0 || arr.size == 0) return 0

    val map: HashMap<Int, Int> = HashMap()
    var pairs = 0
    for (color in arr) { //count=5    pairs=5
                         //                       P
        var count = 1   //10 20 20 10 10 30 50 10 20
        if (map.containsKey(color) && map[color]!!<2) {
            map[color] = map[color]!! + 1
            ++pairs
        } else {
            map[color] = count
        }
    }
    return pairs
}



