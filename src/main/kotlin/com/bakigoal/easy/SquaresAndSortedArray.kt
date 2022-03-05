package com.bakigoal.easy

/**
 * Given an integer array nums sorted in non-decreasing order,
 * return an array of the squares of each number sorted in non-decreasing order.

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].

 */
fun sortedSquares(nums: IntArray): IntArray {
    var left = 0
    var right = nums.size - 1

    val result = IntArray(nums.size)
    var i = nums.size - 1

    while (left <= right) {
        val rightSquare = nums[right] * nums[right]
        val leftSquare = nums[left] * nums[left]

        if (leftSquare < rightSquare) {
            result[i--] = rightSquare
            right--
        } else {
            result[i--] = leftSquare
            left++
        }
    }

    return result
}