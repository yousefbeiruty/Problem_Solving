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
//    System.out.println()
//    System.out.println("---------------------------------------------------")
//    list.pop()
//    list.traverse()
//    System.out.println()
//    System.out.println("---------------------------------------------------")
//    list.pop()
//    System.out.println()
//    System.out.println("---------------------------------------------------")
//    list.pop()
//    System.out.println()
//    list.traverse()
//    System.out.println()
//    System.out.println("---------------------------------------------------")
//    list.shifting()
//    list.traverse()
//    System.out.println()
//    System.out.println("---------------------------------------------------")
//    list.shifting()
//    list.traverse()
//    System.out.println()
//    System.out.println("---------------------------------------------------")
//    list.shifting()
//    list.traverse()
//    list.push("Hello")
//    System.out.println()
//    System.out.println("---------------------------------------------------")
//    list.traverse()
//    list.push("bye")
//    System.out.println()
//    System.out.println("---------------------------------------------------")
//    list.traverse()
//    list.unshift("test")
//    System.out.println()
//    System.out.println("---------------------------------------------------")
//    list.traverse()
//    list.unshift("first")
//    System.out.println()
//    System.out.println("---------------------------------------------------")
//    list.traverse()
//    System.out.println()
//    System.out.println("---------------------------------------------------")
//    System.out.println(list.get(1)?.value)
    System.out.println()
    System.out.println("---------------------------------------------------")
    list.set(1, "0")
    list.traverse()
    System.out.println()
    System.out.println("---------------------------------------------------")
    list.insert(2, "10")
    list.traverse()
    System.out.println()
    System.out.println("---------------------------------------------------")
    list.remove(10)
    list.traverse()
    System.out.println()
    System.out.println("---------------------------------------------------")
    list.reverse2()
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
    fun pop() {
        //Hello-->GoodBye-->!-->null
        var beforeRemoveNode = getBeforeTaill();
        beforeRemoveNode?.next = null
        tail = beforeRemoveNode
        length--
        if (length == 0) {
            head = null
            tail = null
        }
    }

    //it means delete first element in the list
    fun shifting(): SinglyLinkedList<T>? {
        if (length == 0) return null
        // c       nh
        //Hello-->GoodBye-->!-->null
        val newHead = head?.next
        head = newHead
        length--

        return this
    }

    //it means adding a new node to the beginning of the list
    fun unshift(value: T): SinglyLinkedList<T> {
        val newNode = Node<T>(value)
        if (head == null) {
            head = newNode
            tail = head
        } else {
            newNode.next = head
            head = newNode
        }
        length++
        return this
    }

    //Retrieving a node by it's position in the linked list
    fun get(index: Int): Node<T>? {
        var count = 0
        var current = head
        while (current != null) {
            if (count == index) {
                return current
            }
            count++
            current = current.next
        }
        return null
    }

    //changing a value of a node based on it's position in the linked list
    fun set(index: Int, value: T): SinglyLinkedList<T>? {
        var count = 0
        var current = head
        while (current != null) {
            if (count == index) {
                current.value = value
            }
            count++
            current = current.next
        }
        return this
    }

    //Adding a node to the linked list at a specific position
    fun insert(index: Int, value: T): SinglyLinkedList<T>? {
        // c       nh
        //Hello-->GoodBye-->!-->null
        //    \   ^
        //      v /
        //       10
        if (index == 0) {
            unshift(value)
            return this
        } else if (index >= length) {
            push(value)
            return this
        }
        val insertNode = Node<T>(value)
        val beforNode = getBeforeNode(index)
        insertNode.next = beforNode?.next
        beforNode?.next = insertNode
        length++
        return this
    }

    //it remove the node in a specific index
    fun remove(index: Int): SinglyLinkedList<T>?{
        if (index==0){
            shifting()
            return this
        }   else if(index>=length){
            pop()
            return this
        }
        val beforeRemoveNode=getBeforeNode(index)
        val removeNode=get(index)
        beforeRemoveNode?.next=removeNode?.next
        length--
        //Hello-->GoodBye-->!-->null
        //Hello->!-->null
        return this
    }

    fun getBeforeNode(index: Int): Node<T>? {
        var count = 0
        var beforeNode = head
        var currentNode = head
        while (currentNode != null) {
            if (count == index - 1) {
                beforeNode = currentNode
                return beforeNode
            }
            count++
            currentNode = currentNode.next
        }
        return beforeNode
    }

    private fun getBeforeTaill(): Node<T>? {
        var curentNode = head
        var beforeTail = head
        while (curentNode != tail) {
            beforeTail = curentNode
            curentNode = curentNode?.next
        }
        return beforeTail
    }

    fun reverse2(){
//h+n+p    next    t
//Hello --> 0  -->10-->null

//    prev          n    next
//   null<-Hello -->0 -->10-->null

        //        prev   n
//   null<-Hello -->0 -->10-->null

 //        prev     n   next
//   null<-Hello -->0 -->10-->null
// h            t
//10 --> 0 --> Hello -->null

        var node=head
        head=tail
        tail=node

        var next:Node<T>?=null
        var prev:Node<T>?=null

        while (node!=null){
            next=node.next
            node.next=prev
            prev=node
            node=next
        }
    }


    fun traverse() {
        var current = head

        while (current != null) {
            System.out.print("${current.value}-->")
            current = current.next
        }
        System.out.print("null")
    }

    //Reversing the linked list in place !
    fun reverse() {

/*TODO:-the solution is in processing*/

//h+n+p    next    t
//Hello --> 0  -->10-->null

//    prev          n
//   null<-Hello -->0 -->10-->null

 //        prev     n
//   null<-Hello -->0 -->10-->null

 //        prev     n   next
//   null<-Hello -->0 -->10-->null
// h            t
//10 --> 0 --> Hello -->null
        var node=head
        head=tail
        tail=node

        var prev: Node<T>?=null
        var next: Node<T>? =null

        while (node!=null){
            next=node.next
            node.next=prev
            prev=node
            node=next
        }
    }
}