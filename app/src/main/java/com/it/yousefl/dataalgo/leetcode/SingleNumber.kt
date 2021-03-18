package com.it.yousefl.dataalgo.leetcode

import android.os.Build
import androidx.annotation.RequiresApi
import java.util.*

@RequiresApi(Build.VERSION_CODES.N)
fun main() {

    val nums = intArrayOf(4, 1, 2, 1, 2)
   // System.out.println(singleNumber(nums))
  //  System.out.println(excelSheetColumnNumber("AA"))

    val array = intArrayOf(6, 53, 53, 96, 45, 79, 53, 58, 53, 90, 40, 53, 53, 1, 53, 53, 89, 53, 33, 27, 53, 53, 84, 42, 53, 53, 87, 51, 66, 53, 28, 53, 53, 53, 50, 39, 36, 48, 19, 74, 38, 53, 42, 53, 99, 53, 80, 53, 53, 53, 53, 96, 78, 52, 24, 53, 53, 53, 53, 64, 10, 53, 53, 53, 53, 82, 53, 53, 53, 22, 53, 53, 67, 53, 53, 53, 53, 53, 67, 53, 19, 99, 53, 53, 21, 53, 69, 53, 53, 53, 52, 53, 96, 53, 53, 51, 81, 62, 4, 6)
    System.out.println(majorityElement(array))



}




fun singleNumber(nums: IntArray): Int {
    val map = HashMap<Int, Int?>()

    for (i in 0..nums.size-1) {
        var count=1
        if (map.containsKey(nums[i])) {
            map[nums[i]] = ++count
        }else
        map[nums[i]] = count
    }
    for (j in 0..map.size) {
        if (map[nums[j]] != null) {
            if (map[nums[j]] == 1) {
                return nums[j]
            }
        }
    }
    return 0
}


fun excelSheetColumnNumber(s: String): Int {
    var result = 0
    for (i in 0 until s.length) {
        val d = s[i] - 'A' + 1
        result = result * 26 + d
    }
    return result
}


@RequiresApi(Build.VERSION_CODES.N)
fun majorityElement(nums: IntArray): Int {
    if (nums.size <= 1) return nums[0]
    val map = HashMap<Int, Int>()


    for (i in nums.indices) {
        val count = 1
        if (map.containsKey(nums[i]) && map[nums[i]]!! + 1 > nums.size / 2) {
            return nums[i]
        } else {
            map[nums[i]] = map.getOrDefault(nums[i], 0)!! + 1
        }
    }

    return 0
}