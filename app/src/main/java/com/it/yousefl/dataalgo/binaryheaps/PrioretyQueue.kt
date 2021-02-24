package com.it.yousefl.dataalgo.binaryheaps

fun main() {
    //TODO:- Priorety Queue in heaps could be min or max  O(log n)
    // note you can make it using list but is too slow in complexity O(n)
    val er=PrioretyQueue<String>()
    er.enqueue("common cold",5)
    er.enqueue("gunshot",1)
    er.enqueue("broken arm",2)

    System.out.println(er.enqueue("glass in foot",3).get(0).value)
    System.out.println(er.dequeue().value)
}

class NodePriorety<T>(var value: T, var priorety: Int)

class PrioretyQueue<T> {

    val values=ArrayList<NodePriorety<String>>()

    fun enqueue(value:String,priorety: Int):ArrayList<NodePriorety<String>>{
        val newNode=NodePriorety(value,priorety)
        values.add(newNode)
        bubbleUp();
        return values
    }

    fun bubbleUp() {
        var index=values.size-1
        val element=values[index]

        while (index > 0){
            val parentIndex= Math.floor(((index-1)/2).toDouble())
            if ( element.priorety >= values.get(parentIndex.toInt()).priorety) break
            val temp=values[parentIndex.toInt()]
            values[parentIndex.toInt()]=element
            values[index]=temp
            index=parentIndex.toInt()
        }

    }

    fun dequeue(): NodePriorety<String> {
        val min=values[0]
        val end=values[values.size-1]
        values.removeAt(values.size-1)
        if (values.size > 0){
            values[0]=end
            //Trickle down
            sinkDown()
        }
        return  min
    }

    fun sinkDown(){
        var index=0
        val length=values.size
        val element=values[0]

        while (true){
            val leftChildIndex=2*index+1
            val rightChildIndex=2*index+2
            var rightChild:NodePriorety<String>?=null
            var leftChild:NodePriorety<String>?=null
            var swap:Int?=null

            if (leftChildIndex < length){
                leftChild=values[leftChildIndex]
                if (leftChild.priorety < element.priorety){
                    swap=leftChildIndex
                }
            }
            if (rightChildIndex < length){
                rightChild=values[rightChildIndex]
                // [ 33 , 41 , 39 , 18 , 27 ,12] it could be like this and keep comparing that's wrong
                if ((swap==null && rightChild.priorety < element.priorety )
                        //This condition is to handle if the right and the left is larger than the element
                        ||(swap!=null && rightChild.priorety < leftChild?.priorety!!)){
                    swap=rightChildIndex
                }
            }

            if (swap==null)break
            values[index]=values[swap]
            values[swap]=element
            index=swap
        }
    }





}

