package com.bakigoal.easy

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

internal class SquaresAndSortedArrayTest {

    @Test
    fun test1() {
        val squares = sortedSquares(intArrayOf(-4, -1, 0, 3, 10))
        assertContentEquals(intArrayOf(0, 1, 9, 16, 100), squares)
    }

    @Test
    fun test2() {
        val squares = sortedSquares(intArrayOf(-7, -3, 2, 3, 11))
        assertContentEquals(intArrayOf(4, 9, 9, 49, 121), squares)
    }

    @Test
    fun test3() {
        val squares = sortedSquares(intArrayOf(0, 3, 10))
        assertContentEquals(intArrayOf(0, 9, 100), squares)
    }

    @Test
    fun test4() {
        val squares = sortedSquares(intArrayOf(-4, -1, 0))
        assertContentEquals(intArrayOf(0, 1, 16), squares)
    }
}