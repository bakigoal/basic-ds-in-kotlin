package com.bakigoal.easy

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * Note that you must do this in-place without making a copy of the array.
 *
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
 */
fun moveZeroes(nums: IntArray) {
    var k = 0
    for(i in nums.indices) {
        if (nums[i] != 0) {
            nums[k++] = nums[i]
        }
    }

    for(i in k until nums.size) {
        nums[i] = 0
    }
}
