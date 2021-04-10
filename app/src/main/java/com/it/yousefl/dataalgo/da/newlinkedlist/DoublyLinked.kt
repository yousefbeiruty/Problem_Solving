package com.it.yousefl.dataalgo.da.newlinkedlist

fun main() {
    val list = DoublyLink<String>()
    list.push("1")
    list.push("2")
    list.push("3")
    list.push("4")
    list.push("5")
    list.push("6")
    list.push("7")
    list.push("8")
    list.push("9")
    list.push("10")
    list.traverse()
    //list.pop()
    // list.shift()
    // list.unshift("5")
    // list.set(3,"17")
    // list.insert(5,"17")
     list.remove(1)
    System.out.println()
    //   System.out.println(list.get(7)?.value)
    System.out.println("-----------------------------")
    list.traverse()

}

class DoublyNode<T>(var value: T) {
    var next: DoublyNode<T>? = null
    var previous: DoublyNode<T>? = null
}

class DoublyLink<T> {
    var head: DoublyNode<T>? = null
    var tail: DoublyNode<T>? = null
    var length: Int = 0

    //Adding a node to the end of the DoublyLinkList
    fun push(value: T) {
        val newNode = DoublyNode<T>(value)
        if (length == 0) {
            head = newNode
            tail = newNode
        } else {
            tail?.next = newNode
            newNode.previous = tail
            tail = newNode
            tail?.next = null
        }
        length++
    }

    //Remove a node from the beginning of the DoublyLinked list
    fun shift() {
        if (length == 0) return
        if (length == 1) {
            head = null
            tail = null
        } else {
            //1<->2<->3
            val oldHead = head
            head = oldHead?.next
            head?.previous = null
        }
        length--
    }

    //Removing a node from the end of the DoublyLinked list
    fun pop() {
        if (length == 0) return

        val popedNode = tail
        if (length == 1) {
            head = null
            tail = null
        } else {
            tail = popedNode?.previous
            tail?.next = null
        }
        length--
    }

    //Adding a node to the beginning of the DoublyLinked list
    fun unshift(value: T) {
        val neNode = DoublyNode(value)
        if (length == 0) {
            head = neNode
            tail = neNode
        } else {
            //1<-><->2<->3
            neNode.next = head
            head?.previous = neNode
            head = neNode
        }
        length++
    }

    //Accessing a node in a DoublyLinked list by it's position
    fun get(index: Int): DoublyNode<T>? {
        //1<-><->2<->3
        if (length == 0) return null
        var currentNode: DoublyNode<T>?
        var count: Int
        /**this is a faster solutionto check if the index is less than half the length wes start from the head if
         * the index is greater than half the length we start from the tail
         * */
        if (index <= (length / 2)) {
            currentNode = head
            count = 0
            while (currentNode != null) {
                if (count == index) {
                    return currentNode
                }
                count++
                currentNode = currentNode.next
            }
        } else {
            currentNode = tail
            count = length - 1
            while (currentNode != null) {
                if (count == index) {
                    return currentNode
                }
                count--
                currentNode = currentNode.previous
            }

        }
        return null
    }

    //replacing the value of a node to the in DoublyLinked list
    fun set(index: Int, value: T) {
        if (length == 0) return
        //1<-><->2<->3
        val replacedNode = get(index)
        replacedNode?.value = value

    }

    //Adding a node a DoublyLinked list by a certain position
    fun insert(index: Int, value: T) {
        if (index == 0) {
            unshift(value)
        } else if (index == length - 1) {
            push(value)
        }
        //1<->4<->2<->3
        //
        //7
        val newNode = DoublyNode(value)
        val nodeAftre = get(index)
        val nodeBefore = get(index - 1)
        newNode.next = nodeAftre
        nodeBefore?.next = newNode
        nodeAftre?.previous = newNode
        newNode.previous = nodeBefore
        length++
    }

    //Remove a node in a DoublyLinked list in a certain position
    fun remove(index: Int) {
        if (length == 0) return
        if (index == 0) {
            shift()
        } else if (index == length - 1) {
            pop()
        }

        //1<->4<->2<->3
        val beforRemoveNode = get(index - 1)
        val removedNode = get(index)
        val afterRemoveNode = get(index + 1)
        beforRemoveNode?.next = afterRemoveNode
        afterRemoveNode?.previous = beforRemoveNode
        removedNode?.next=null
        removedNode?.previous=null
        length--
    }

    fun traverse() {
        if (length == 0) return

        var currentNode = head

        while (currentNode != null) {
            System.out.print("${currentNode.value}<-->")
            currentNode = currentNode.next
        }
        System.out.print("null")
    }
}

