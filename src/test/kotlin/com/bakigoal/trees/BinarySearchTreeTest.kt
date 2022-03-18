package com.bakigoal.trees

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class BinarySearchTreeTest {

    private lateinit var bst: BinarySearchTree<Int>

    @BeforeEach
    fun init() {
        bst = BinarySearchTree(4)
        bst.insert(2)
        bst.insert(3)
        bst.insert(1)
        bst.insert(6)
        bst.insert(5)
        bst.insert(7)
        println(bst)
    }

    @Test
    fun lowestAncestor() {
        assertEquals(4, bst.lowestCommonAncestor(1, 5)?.value)
        assertEquals(2, bst.lowestCommonAncestor(1, 3)?.value)
        assertEquals(6, bst.lowestCommonAncestor(6, 7)?.value)
        assertEquals(4, bst.lowestCommonAncestor(3, 5)?.value)
    }

    @Test
    fun deleteTest() {
        assertEquals(
            """
│         ┌─── 7
│    ┌─── 6
│    │    └─── 5
└─── 4
     │    ┌─── 3
     └─── 2
          └─── 1""".trim(),
            bst.toString().trim()
        )

        bst.delete(2)
        assertEquals(
            """
│         ┌─── 7
│    ┌─── 6
│    │    └─── 5
└─── 4
     └─── 3
          └─── 1""".trim(),
            bst.toString().trim()
        )
    }
}