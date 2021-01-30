package com.it.yousefl.dataalgo.stackandqueues

import com.it.yousefl.dataalgo.newlinkedlist.Node
import com.it.yousefl.dataalgo.newlinkedlist.SinglyLinkedList
import java.util.*

fun main() {

    val stack=Stack<Int>()
    stack.push(10)
    stack.push(20)
    stack.push(30)
    //stack.pop()
    System.out.println(stack.first?.value)


}


class StackNode<T>(var value: T) {
    var next: StackNode<T>? = null
}

class Stack<T>{
    var first:StackNode<T>?=null
    var last:StackNode<T>?=null
    var size=0

    //it means delete last element in the Stack
    fun pop(): Stack<T>? {
        if (size == 0) return null
        //
        //3
        //|
        //v
        //2
        //|
        //v
        //1
        val newHead = first?.next
        if (first==last){
            last=null
        }
        first = newHead
        size--
        return this
    }

    //it means adding a new node to  the Stack
    fun push(value: T):Stack<T> {
        //
        //
        //2
        //|
        //v
       // 1
        val newNode = StackNode(value)
        if (first == null) {
            first = newNode
            last = first
        } else {
            val temp=first
            first=newNode
            first?.next = temp
        }
        size++
        return this
    }
}
