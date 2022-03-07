package com.bakigoal.easy

/**
 * Given a string s, reverse the order of characters in each word within a sentence
 * while still preserving whitespace and initial word order.
 *
Input: s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
 */
fun reverseWords(s: String): String {
    val result = StringBuilder()
    for (word in s.split(" ")) {
        result.append(reverseWord(word)).append(" ")
    }
    return result.toString().trimEnd()
}

fun reverseWord(word: String): String {
    val s = word.toCharArray()
    var left = 0
    var right = s.size - 1

    while (left < right) {
        val temp = s[left]
        s[left++] = s[right]
        s[right--] = temp
    }
    return String(s)
}
