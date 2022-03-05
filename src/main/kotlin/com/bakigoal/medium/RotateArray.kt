package com.bakigoal.medium

/**
 * Given an array, rotate the array to the right by k steps, where k is non-negative.

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
 */
fun rotate(nums: IntArray, k: Int): Unit {
    val mid = k % nums.size
    reverse(nums, 0, nums.size - 1)
    reverse(nums, 0, mid - 1)
    reverse(nums, mid, nums.size - 1)
}

fun reverse(nums: IntArray, start: Int, end: Int) {
    var left = start
    var right = end

    while (left < right) {
        val temp = nums[left]
        nums[left] = nums[right]
        nums[right] = temp
        left ++
        right --
    }
}
