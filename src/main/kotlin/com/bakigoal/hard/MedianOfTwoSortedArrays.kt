package com.bakigoal.hard

/**
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 */
fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    var index1 = 0
    var index2 = 0
    var median1 = 0
    var median2 = 0
    val size1 = nums1.size
    val size2 = nums2.size

    for (i in 0..(size1 + size2) / 2) {
        median1 = median2
        when {
            index1 == size1 -> {
                median2 = nums2[index2]
                index2++
            }
            index2 == size2 -> {
                median2 = nums1[index1]
                index1++
            }
            nums1[index1] < nums2[index2] -> {
                median2 = nums1[index1]
                index1++
            }
            else -> {
                median2 = nums2[index2]
                index2++
            }
        }
    }

    return if ((size1 + size2) % 2 == 0) {
        ((median1 + median2).toFloat() / 2).toDouble()
    } else {
        median2.toDouble()
    }
}