package com.bakigoal.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class LongestSubstringWithoutRepeatingTest {

    @Test
    fun `test longest substring` () {
        assertEquals(3, lengthOfLongestSubstring("abcabcbb"))
        assertEquals(1, lengthOfLongestSubstring("bbbbb"))
        assertEquals(3, lengthOfLongestSubstring("pwwkew"))
        assertEquals(1, lengthOfLongestSubstring("b"))
        assertEquals(3, lengthOfLongestSubstring("dvdf"))
    }
}