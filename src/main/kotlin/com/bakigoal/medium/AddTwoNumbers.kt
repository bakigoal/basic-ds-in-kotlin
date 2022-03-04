package com.bakigoal.medium

data class ListNode(var `val`: Int, var next: ListNode? = null) {
    override fun toString(): String {
        return "$`val` -> ${next?.toString()}"
    }
}

/**
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 *
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 *
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 */
fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var node1 = l1
    var node2 = l2
    var inMemory = 0
    val result = ListNode(-1)
    var currentNode = result

    while (node1 != null || node2 != null) {
        val sum = (node1?.`val` ?: 0) + (node2?.`val` ?: 0) + inMemory
        inMemory = sum / 10
        currentNode.next = ListNode(sum % 10)
        currentNode = currentNode.next!!

        node1 = node1?.next
        node2 = node2?.next
    }

    if (inMemory > 0) {
        currentNode.next = ListNode(inMemory)
    }

    return result.next
}