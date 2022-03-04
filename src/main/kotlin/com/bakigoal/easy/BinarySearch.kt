package com.bakigoal.easy

/**
 * Given an array of integers nums which is sorted in ascending order,
 * and an integer target, write a function to search target in nums.
 * If target exists, then return its index. Otherwise, return -1.
 */
fun search(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.size - 1

    while (left <= right) {
        val middle = (left + right) / 2
        val value = nums[middle]
        when {
            value < target -> left = middle + 1
            value > target -> right = middle - 1
            else -> return middle
        }
    }
    return -1
}