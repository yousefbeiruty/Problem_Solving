package com.it.yousefl.dataalgo.da.linkedlist

fun main() {
    //Singly LinkedList
    //head     tail
// 10-->5-->16
//    val mylinkedList =
//        hashMapOf(
//            ("head" to
//                    hashMapOf(
//                        "value" to 10,
//                        "next" to hashMapOf(
//                            "value" to 5,
//                            "next" to hashMapOf("value" to 16),
//                            "next" to null
//                        )
//                    ))
//        )


    val linkedList = LinkedList(10)
    linkedList.append(5)
    linkedList.append(16)
    linkedList.prepend(1)
    linkedList.insert(10, 12)
    linkedList.insert(2, 50)
    linkedList.insert(4, 4)
    linkedList.printList()
    System.out.println("")
    linkedList.remove(0)
    linkedList.printList()
    System.out.println("")
    System.out.println("--------------------------------------------------------------------------")
    linkedList.reverse()
    linkedList.printList()


}

class SinglyNode(var value: Int) {
    var next: SinglyNode? = null
}

class LinkedList constructor(val value: Int) {
    var head: SinglyNode?
    var tail: SinglyNode?
    var length = 0

    init {
        head = SinglyNode(value)
        tail = head
        length = 1
    }

    //add the node i the last of the list
    fun append(newValue: Int): LinkedList {
        val newNode = SinglyNode(newValue)
        tail?.next = newNode
        tail = newNode
        tail?.next = null
        length++
        return this
    }

    //add the node in the first (beginning of the list)
    fun prepend(newValue: Int): LinkedList? {
        val newNode = SinglyNode(newValue)
        newNode.next = head
        head = newNode
        length++
        return this
    }

    fun printList() {
        if (head == null) {
            return
        }
        var currentNode: SinglyNode? = head
        //   System.out.print(currentNode.value)
//       currentNode = currentNode.next!!
        while (currentNode != null) {
            System.out.print("${currentNode.value}-->")
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


        val newNode = SinglyNode(value)
        val leader = traverseToIndex(index - 1)
        var holdingPpointer = leader?.next
        leader?.next = newNode
        newNode.next = holdingPpointer
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
        var holdingPpointer = leader?.next
        leader?.next = holdingPpointer?.next
        length--
    }

    private fun traverseToIndex(index: Int): SinglyNode? {
        var count = 0
        var pointer = head
        while (count != index) {
            pointer = pointer?.next
            count++
        }
        return pointer
    }

    fun reverse(){
        if(length<=0 || length==1)
            return
        var first=head
        tail=head
        var second=first?.next

      while (second!=null){
         val temp=second.next
          second.next=first
          first=second
          second=temp
         }
        head?.next =null
        head=first
    }

}