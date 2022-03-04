package com.bakigoal.medium

import org.junit.jupiter.api.Test

internal class AddTwoNumbersTest {

    @Test
    fun `add two numbers`() {
        val l1 = ListNode(2)
        l1.next = ListNode(4)
        l1.next!!.next = ListNode(3)
        val l2 = ListNode(5)
        l2.next = ListNode(6)
        l2.next!!.next = ListNode(4)
        val addTwoNumbers = addTwoNumbers(l1, l2)
        println(addTwoNumbers)
    }

    @Test
    fun `add two numbers 2`() {
        val l1 = ListNode(9)
        l1.next = ListNode(9)
        l1.next!!.next = ListNode(9)
        l1.next!!.next!!.next = ListNode(9)
        l1.next!!.next!!.next!!.next = ListNode(9)
        l1.next!!.next!!.next!!.next!!.next = ListNode(9)
        l1.next!!.next!!.next!!.next!!.next!!.next = ListNode(9)
        val l2 = ListNode(9)
        l2.next = ListNode(9)
        l2.next!!.next = ListNode(9)
        l2.next!!.next!!.next = ListNode(9)
        val addTwoNumbers = addTwoNumbers(l1, l2)
        println(addTwoNumbers)
    }
}