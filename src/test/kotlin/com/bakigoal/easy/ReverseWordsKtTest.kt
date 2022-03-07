package com.bakigoal.easy

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ReverseWordsKtTest {

    @Test
    fun t1() {
        val reverseWords = reverseWords("Let's take LeetCode contest")
        println(reverseWords)
        assertEquals("s'teL ekat edoCteeL tsetnoc", reverseWords)
    }
}