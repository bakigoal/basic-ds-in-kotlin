package com.bakigoal.trees

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.lang.StringBuilder
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
    }

    @Test
    fun toStringTest() {
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
    }

    @Test
    fun insertTest() {
        bst.insert(8)
        assertEquals(
            """
│              ┌─── 8
│         ┌─── 7
│    ┌─── 6
│    │    └─── 5
└─── 4
     │    ┌─── 3
     └─── 2
          └─── 1""".trim(),
            bst.toString().trim()
        )
    }

    @Test
    fun deleteTest() {
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

    @Test
    fun lowestAncestor() {
        assertEquals(4, bst.lowestCommonAncestor(1, 5)?.value)
        assertEquals(2, bst.lowestCommonAncestor(1, 3)?.value)
        assertEquals(6, bst.lowestCommonAncestor(6, 7)?.value)
        assertEquals(4, bst.lowestCommonAncestor(3, 5)?.value)
    }

    @Test
    fun minMaxTest () {
        assertEquals(7, bst.max().value)
        assertEquals(1, bst.min().value)
    }

    @Test
    fun levelOrderTraversalTest() {
        val stringBuilder = StringBuilder()
        bst.levelOrderTraversal{ stringBuilder.append(it) }
        assertEquals("4261357", stringBuilder.toString())
    }

    @Test
    fun preOrderTraversalTest() {
        val stringBuilder = StringBuilder()
        bst.preOrderTraversal{ stringBuilder.append(it) }
        assertEquals("4213657", stringBuilder.toString())
    }

    @Test
    fun inOrderTraversalTest() {
        val stringBuilder = StringBuilder()
        bst.inOrderTraversal{ stringBuilder.append(it) }
        assertEquals("1234567", stringBuilder.toString())
    }

    @Test
    fun postOrderTraversalTest() {
        val stringBuilder = StringBuilder()
        bst.postOrderTraversal{ stringBuilder.append(it) }
        assertEquals("1325764", stringBuilder.toString())
    }
}