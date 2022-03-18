package com.bakigoal.trees

data class Node<T: Comparable<T>>(
    val value: T,
    var left: Node<T>? = null,
    var right: Node<T>? = null
) {
    override fun toString(): String {
        return prettyPrintTree(this, "", true)
    }

    private fun prettyPrintTree(node: Node<T>?, prefix: String, isLeft: Boolean): String {
        if (node == null) {
            return "Empty"
        }
        val sb = StringBuilder()
        if (node.right != null) {
            sb.append(prettyPrintTree(node.right, prefix + if (isLeft) "│    " else "     ", false))
        }
        sb.append(prefix + (if (isLeft) "└─── " else "┌─── ") + node.value).append("\n")
        if (node.left != null) {
            sb.append(prettyPrintTree(node.left, prefix + if (isLeft) "     " else "│    ", true))
        }
        return sb.toString()
    }
}