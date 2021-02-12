package com.it.yousefl.dataalgo.graph

import com.it.yousefl.dataalgo.stackandqueues.Queue
import com.it.yousefl.dataalgo.stackandqueues.Stack

fun main() {

    val graph=Graph()
//    graph.addVertex("Tokyo")
//    graph.addVertex("America")
//    graph.addVertex("Aspen")
//    graph.addVertex("Jordan")
//    graph.addEdge("Tokyo","America")
//    graph.addEdge("Aspen","Jordan")

//    System.out.println(graph.addEdge("Aspen","Tokyo"))
//    System.out.println(graph.removeEdge("Aspen","Tokyo"))
//    System.out.println(graph.removeEdge("Aspen","Jordan"))
 //   System.out.println(graph.removeVertex("Tokyo"))


    graph.addVertex("A")
    graph.addVertex("B")
    graph.addVertex("C")
    graph.addVertex("D")
    graph.addVertex("E")
    graph.addVertex("F")

    graph.addEdge("A","B")
    graph.addEdge("A","C")
    graph.addEdge("B","D")
    graph.addEdge("C","E")
    graph.addEdge("D","E")
    graph.addEdge("D","F")



    System.out.println( graph.addEdge("E","F"))
//    System.out.println(graph.DFSrecursive("A"))//[A, B, D, E, C, F]
  //  System.out.println(graph.DFSiterative("A"))//[A, C, E, F, D, B]
    System.out.println(graph.BFS("A"))

    //TODO:-   A         Graph Traversal
    //      /     \
    //     B       C
    //     \       |
    //      D------E
    //       \    /
    //         F
}



class Graph {
    private val adjacencyList=HashMap<String,ArrayList<String>>()

    fun addVertex(vertexName:String): HashMap<String, ArrayList<String>> {
        if (!adjacencyList.containsKey(vertexName)){
            adjacencyList[vertexName] = arrayListOf()
        }
        return adjacencyList
    }

    fun addEdge(vertex1:String,vertex2:String): HashMap<String, ArrayList<String>> {
            adjacencyList[vertex1]?.add(vertex2)
            adjacencyList[vertex2]?.add(vertex1)

       return adjacencyList
    }

    fun removeEdge(vertex1:String,vertex2:String): HashMap<String, ArrayList<String>> {
        adjacencyList[vertex1]?.remove(vertex2)

        adjacencyList[vertex2]?.remove(vertex1)
        return adjacencyList
    }

    fun removeVertex(vertex:String): HashMap<String, ArrayList<String>> {
         while (adjacencyList[vertex]?.size!=0){
             val adjcentVertex= adjacencyList[vertex]?.size?.minus(1)?.let { adjacencyList[vertex]?.removeAt(it) }
             adjcentVertex?.let { removeEdge(vertex, it) }
          }
        adjacencyList.remove(vertex)
        return adjacencyList
    }

    fun DFSrecursive(startingVertex:String): ArrayList<String> {
     val resultList=ArrayList<String>()
     val visited=HashMap<String,Boolean>()

        fun helper(vertex:String){
            if (vertex.isEmpty()) return

            visited.put(vertex,true)
            resultList.add(vertex)
            //TODO:-   A         Graph Traversal
            //      /     \
            //     B       C
            //     \       |
            //      D------E
            //       \    /
            //         F
            adjacencyList[vertex]?.forEach{
                if (!visited.containsKey(it)){
                    System.out.println(it)
                   helper(it)
                }

            }
        }
        helper(startingVertex)
        System.out.println(visited)
        return resultList
    }

    fun DFSiterative(startingVertex:String): ArrayList<String> {
      val stack=Stack<String>()
      val results=ArrayList<String>()
      val visited=HashMap<String,Boolean>()
        var vertex:String
        stack.push(startingVertex)
        visited.put(startingVertex,true)

        while (stack.size!=0){
             vertex=stack.first?.value.toString()
             results.add(vertex)
            stack.pop()
            adjacencyList[vertex]?.forEach {neighbor->
                    if (!visited.containsKey(neighbor)) {
                        visited.put(neighbor,true)
                        stack.push(neighbor)
                    }
            }
        }
        return results
    }

    fun BFS(startingVertex: String): ArrayList<String> {
        val queue=Queue<String>()
        val results=ArrayList<String>()
        val visited=HashMap<String,Boolean>()
        var vertex:String
                visited.put(startingVertex,true)
        queue.enqueue(startingVertex)
        while (queue.size!=0){
            vertex=queue.first?.value.toString()
            queue.dequeue()
            results.add(vertex)
            adjacencyList[vertex]?.forEach {neighbor->
                //TODO: Q:-[D,E]
                //     Results[A, B, C,]
                if (!visited.containsKey(neighbor)){
                    visited.put(neighbor,true)
                    queue.enqueue(neighbor)
                }
            }
        }
       return results
    }
}
