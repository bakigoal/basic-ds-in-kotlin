package com.bakigoal.easy

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

internal class TwoSumTest {

    @Test
    fun `two sum test`() {
        val result = twoSum(intArrayOf(2, 3, 4, 5), 8)
        assertContentEquals(intArrayOf(1, 3).sorted(), result.sorted())
    }
}