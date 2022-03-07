package com.bakigoal.easy

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

internal class ReverseStringKtTest {

    @Test
    fun test1() {
        val charArrayOf = charArrayOf('h', 'e', 'l', 'l', 'o')
        reverseString(charArrayOf)
        assertContentEquals(charArrayOf('o', 'l', 'l', 'e', 'h'), charArrayOf)
    }
}