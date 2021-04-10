package com.it.yousefl.dataalgo.da.stackandqueues

fun main() {

    val queue=Queue<Int>()
    queue.enqueue(10)
    queue.enqueue(20)
    queue.dequeue()
    System.out.println(queue.first?.value)
}

class QueueNode<T>(var value:T){
    var next:QueueNode<T>?=null
}


class Queue<T>{
    var first:QueueNode<T>?=null
    var last :QueueNode<T>?=null
    var size=0

    //Adding from the last(tail)
    fun enqueue(value:T){
        val newNode=QueueNode(value)
        if (first==null){
            first=newNode
            last=newNode
        }else{
           // F              L
           // 1 -> 2 -> 3 -> 4   -> newNode
            // F                      L
            // 1 -> 2 -> 3 -> 4  -> newNode
            last?.next=newNode
            last=newNode
        }
        size++
    }

    //Removing from the first(head)
    fun dequeue(): QueueNode<T>?{
        if (size==0) return null

        if (first==last){
            last=null
        }
        // F              L
        // 1 -> 2 -> 3 -> 4   -> newNode
        val temp=first
        first=first?.next
        size--
        return temp
    }
}