package com.bakigoal.easy

import java.util.HashMap

fun twoSum(nums: IntArray, target: Int): IntArray {
    val cache = HashMap<Int, Int>()
    for (i in nums.indices) {
        val expected = target - nums[i]
        if (cache.containsKey(expected)) {
            return intArrayOf(i, cache[expected]!!)
        }
        cache[nums[i]] = i
    }
    throw IllegalArgumentException("No two sum solution")
}