package com.bakigoal.medium

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class ParseIntKtTest {

    @Test
    fun `test by tdd`() {
        assertEquals(42, myAtoi("42"))
        assertEquals(-42, myAtoi("-42"))
        assertEquals(0, myAtoi("+-12"))
        assertEquals(4193, myAtoi("4193 with words"))
        assertEquals(0, myAtoi("words and 987"))
        assertEquals(3, myAtoi("3.14159"))
        assertEquals(Int.MIN_VALUE, myAtoi("-91283472332"))
        assertEquals(Int.MAX_VALUE, myAtoi("9223372036854775808"))
    }
}