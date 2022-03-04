package com.bakigoal.medium

/**
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 */
fun lengthOfLongestSubstring(s: String): Int {
    var substring = ""
    var max = 0
    for (c in s){
        if (substring.contains(c)) {
            if (substring.length > max) {
                max = substring.length
            }
            substring = substring.substring(substring.indexOf(c) + 1)
        }
        substring += c
    }
    if (substring.length > max) {
        max = substring.length
    }
    return max
}