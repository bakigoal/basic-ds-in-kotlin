package com.bakigoal.easy

import java.lang.IllegalArgumentException

fun twoSum2(nums: IntArray, target: Int): IntArray {

    for (i in 0..nums.size - 2) {
        val expected = target - nums[i]

        var left = i + 1
        var right = nums.size - 1

        while (left <= right) {
            val mid = (left + right) / 2
            if (nums[mid] == expected) {
                return intArrayOf(i + 1, mid + 1)
            }
            if (nums[mid] > expected) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
    }
    throw IllegalArgumentException()
}