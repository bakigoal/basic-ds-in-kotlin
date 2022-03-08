package com.bakigoal.medium

/**
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]

Input: head = [1], n = 1
Output: []
 */
fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? = deleteNode(head, getSize(head) - n)

private fun getSize(head: ListNode?): Int {
    var current = head
    var size = 0
    while (current != null) {
        size++
        current = current.next
    }
    return size
}

fun deleteNode(head: ListNode?, deleteIndex: Int): ListNode? {
    if (deleteIndex == 0) {
        return head?.next
    }

    var index = 0
    var current = head
    var prev = head
    while (current != null) {
        if (index++ == deleteIndex) {
            prev!!.next = current.next
            break
        }
        prev = current
        current = current.next
    }
    return head
}
