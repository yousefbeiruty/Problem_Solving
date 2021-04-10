package com.it.yousefl.dataalgo.da.linkedlist

fun main() {
    val linkedList = DoublyLinkedList(10)
    linkedList.append(5)
    linkedList.append(16)
    linkedList.prepend(1)
    linkedList.insert(10, 12)
    linkedList.insert(2, 50)
    linkedList.insert(4, 4)
    linkedList.printList()
    System.out.println("")
    linkedList.remove(4)
    linkedList.printList()
    System.out.println("")


}

class DoublyNode(var value: Int) {
    var next: DoublyNode? = null
    var previous: DoublyNode? = null
}

class DoublyLinkedList constructor(val value: Int) {
    var head: DoublyNode?
    var tail: DoublyNode?
    var length = 0

    init {
        head = DoublyNode(value)
        tail = head
        length = 1
    }

    //// 10-->5-->16-->9
    //add the node i the last of the list
    fun append(newValue: Int): DoublyLinkedList {
        val newNode = DoublyNode(newValue)
        tail?.next = newNode
        newNode.previous=tail
        tail = newNode
        tail?.next = null
        length++
        return this
    }

    //add the node in the first (beginning of the list)
    fun prepend(newValue: Int): DoublyLinkedList? {
        val newNode = DoublyNode(newValue)
        newNode.next = head
        head?.previous=newNode
        head = newNode
        length++
        return this
    }

    fun printList() {
        if (head == null) {
            return
        }
        var currentNode: DoublyNode? = head
        //   System.out.print(currentNode.value)
//       currentNode = currentNode.next!!
        while (currentNode != null) {
            System.out.print("${currentNode.value}<-->")
            currentNode = currentNode?.next
        }
    }

    //0  1    2
//1-->10-->5-->16-->null
    // \   /
    //  \ /
    //   9
    fun insert(index: Int, value: Int) {
        if (index >= length) {
            append(value)
        } else if (index == 0)
            prepend(value)


        val newNode = DoublyNode(value)
        val leader = traverseToIndex(index - 1)
        var holdingPpointer = leader?.next
        leader?.next = newNode
        newNode.next = holdingPpointer
        newNode.previous=leader
        holdingPpointer?.previous=newNode
        length++
    }

    //0   1  2
//1->10->50
//1->50
    fun remove(index: Int) {
        if (index==0){
            head=head?.next
        }
        val leader = traverseToIndex(index - 1)
        var fllowerNode = leader?.next
        leader?.next = fllowerNode?.next
        fllowerNode?.previous=leader
        length--
    }

    private fun traverseToIndex(index: Int): DoublyNode? {
        var count = 0
        var pointer = head
        while (count != index) {
            pointer = pointer?.next
            count++
        }
        return pointer
    }






}