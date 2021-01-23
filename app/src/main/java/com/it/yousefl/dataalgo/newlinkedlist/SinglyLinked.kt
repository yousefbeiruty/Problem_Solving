package com.it.yousefl.dataalgo.newlinkedlist

import com.it.yousefl.dataalgo.linkedlist.SinglyNode
import java.util.*

fun main() {

//    var first=Node("hi")
//    first.next=Node("there")
//    first.next?.next=Node("how")
//    first.next?.next?.next=Node("are")
//    first.next?.next?.next?.next=Node("are")
    //  System.out.println(first)

    val list = SinglyLinkedList<String>()
    list.push("Hello")
    list.push("GoodBye")
    list.push("!")
    list.traverse()
    System.out.println()
    System.out.println("---------------------------------------------------")
    list.pop()
    list.traverse()
    System.out.println()
    System.out.println("---------------------------------------------------")
    list.pop()
    System.out.println()
    System.out.println("---------------------------------------------------")
    list.pop()
    list.traverse()

}

class Node<T>(var value: T) {
    var next: Node<T>? = null
}

class SinglyLinkedList<T> {

    var head: Node<T>? = null
    var tail: Node<T>? = null
    var length = 0

    //it mean add at the end of the list
    fun push(value: T): SinglyLinkedList<T> {
        var newNode = Node<T>(value)
        if (head == null) {
            head = newNode
            tail = head
        } else {
            tail?.next = newNode
            tail = newNode
        }
        length++
        return this
    }

    //it means remove the last node in the list
    fun pop(){
        //Hello-->GoodBye-->!-->null
        var beforeRemoveNode=getBeforeTaill();
        beforeRemoveNode?.next=null
        tail=beforeRemoveNode
        length--
        if(length==0){
            head=null
            tail=null
        }
    }

    private fun getBeforeTaill(): Node<T>? {
        var curentNode=head
        var beforeTail=head
        while (curentNode!=tail){
            beforeTail= curentNode
            curentNode=curentNode?.next
        }
        return beforeTail
    }


    fun traverse(){
        var current=head

        while (current!=null){
            System.out.print("${current.value}-->")
            current=current.next
        }
        System.out.print("null")
    }
}




