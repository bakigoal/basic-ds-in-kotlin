package com.bakigoal.easy

/**
Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
 */
fun reverseString(s: CharArray): Unit {
    var left = 0
    var right = s.size - 1

    while (left < right) {
        swap(s, left++, right--)
    }
}

fun swap(s: CharArray, left: Int, right: Int) {
    val temp = s[left]
    s[left] = s[right]
    s[right] = temp
}
