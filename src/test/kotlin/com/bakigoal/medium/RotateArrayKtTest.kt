package com.bakigoal.medium

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

internal class RotateArrayKtTest {

    @Test
    fun test1() {
        val initial = intArrayOf(1, 2, 3, 4, 5, 6, 7)
        rotate(initial, 3)
        assertContentEquals(intArrayOf(5, 6, 7, 1, 2, 3, 4), initial)
    }

    @Test
    fun test2() {
        val initial = intArrayOf(-1, -100, 3, 99)
        rotate(initial, 2)
        assertContentEquals(intArrayOf(3, 99, -1, -100), initial)
    }
}