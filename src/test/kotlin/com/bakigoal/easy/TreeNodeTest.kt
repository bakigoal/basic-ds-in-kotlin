package com.bakigoal.easy

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class TreeNodeTest {

    @Test
    fun `tree pretty print`() {
        val treeNode =
            TreeNode(
                1,
                TreeNode(
                    3,
                    TreeNode(4),
                    TreeNode(5)
                ),
                TreeNode(
                    2,
                    TreeNode(
                        7,
                        TreeNode(8)
                    ),
                    TreeNode(
                        6,
                        TreeNode(10),
                        TreeNode(9)
                    )
                )
            )
        val prettyPrint = treeNode.prettyPrint()

        println(prettyPrint)

        val expected = """
│           ┌── 9
│       ┌── 6
│       │   └── 10
│   ┌── 2
│   │   └── 7
│   │       └── 8
└── 1
    │   ┌── 5
    └── 3
        └── 4

""".trimIndent()
        assertEquals(expected, prettyPrint)
    }
}