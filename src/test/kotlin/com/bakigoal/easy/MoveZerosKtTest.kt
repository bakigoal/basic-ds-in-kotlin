package com.bakigoal.easy

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

internal class MoveZerosKtTest {

    @Test
    fun test1() {
        val intArrayOf = intArrayOf(0)
        moveZeroes(intArrayOf)
        assertContentEquals(intArrayOf(0), intArrayOf)
    }

    @Test
    fun test2() {
        val intArrayOf = intArrayOf(0, 1, 0, 3, 12)
        moveZeroes(intArrayOf)
        assertContentEquals(intArrayOf(1, 3, 12, 0, 0), intArrayOf)
    }

    @Test
    fun test3() {
        val intArrayOf = intArrayOf(0, -1, 0, 3, 10)
        moveZeroes(intArrayOf)
        assertContentEquals(intArrayOf(-1, 3, 10, 0, 0), intArrayOf)
    }
}