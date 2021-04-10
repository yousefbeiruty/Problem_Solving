package com.it.yousefl.dataalgo.da.graph

import com.it.yousefl.dataalgo.da.binaryheaps.PrioretyQueue

fun main() {
val graph=WeightedGraph()
    graph.addVertex("A")
    graph.addVertex("B")
    graph.addVertex("C")
    graph.addVertex("D")
    graph.addVertex("E")
    graph.addVertex("F")


//    System.out.println( graph.addEdge("A","B","10"))
//    System.out.println( graph.addEdge("A","C","5"))
//    System.out.println( graph.addEdge("B","C","7"))

    graph.addEdge("A","B","4")
    graph.addEdge("A","C","2")
    graph.addEdge("B","E","3")
    graph.addEdge("C","D","2")
    graph.addEdge("C","F","4")
    graph.addEdge("D","E","3")
    graph.addEdge("D","F","1")
    graph.addEdge("E","F","1")
    //              4
    //TODO:-    A ----B
    //       2/ 2     3 \3
    //       C----D -----E
   //        4\  /1     /
  //           F--------
    //              1
   System.out.println(graph.DijkstraAlgorithm("A","E"))//[ A, C, D, F, E]
}
//TODO:-Note that it's gonna be a litele differnt
// it will look like this {"A":[{node:"B",weight:10}]}
class WeightedGraph {
    private val adjacencyList=HashMap<String,ArrayList<HashMap<String,String>>>()

    fun addVertex(vertexName:String): HashMap<String,ArrayList<HashMap<String,String>>>{
        if (!adjacencyList.containsKey(vertexName)){
            adjacencyList[vertexName] = arrayListOf()
        }
        return adjacencyList
    }

    fun addEdge(vertex1:String,vertex2: String,weight:String): HashMap<String, ArrayList<HashMap<String, String>>> {
       val hashMap1=HashMap<String,String>()
        hashMap1.put("node",vertex2)
        hashMap1.put("weight",weight)
        adjacencyList[vertex1]?.add(hashMap1)
        val hashMap2=HashMap<String,String>()
        hashMap2.put("node",vertex1)
        hashMap2.put("weight",weight)
        adjacencyList[vertex2]?.add(hashMap2)

        return adjacencyList
    }

    //There is a bug in the code need to solve it
    fun DijkstraAlgorithm(start:String,finish:String): String {
        //TODO:-this algorithm find the shortest path between two points (we use it in graphs)
       val nodes=PrioretyQueue<Int>()
       val distances=HashMap<String,Int>()
       val previous=HashMap<String,String?>()
       var smallest:String=""
       val path=ArrayList<String>()//to return at the end
        //build up initial state
        for (vertex in adjacencyList){
            if (vertex.key==start){
                distances.put(vertex.key,0)
                nodes.enqueue(vertex.key,0)
            }else{
                distances.put(vertex.key, (1.0/0.0).toInt())
                nodes.enqueue(vertex.key,(1.0/0.0).toInt())
            }
            previous.put(vertex.key,null)
        }
        //as long there is something to visit
        while (nodes.values.size!=0){
        smallest=nodes.dequeue().value
            if (smallest==finish){
                //We are done
                //Build Path To Return At End
                while (previous[smallest]!=null){
                    path.add(smallest)
                    smallest= previous[smallest].toString()
                }
                break
            }
            if (
                   !smallest.isEmpty()||
                    distances[smallest]!=(1.0/0.0).toInt()){
                adjacencyList[smallest]?.forEach {neighnor->
                    //find neighboring node
                    val nextNode = adjacencyList[smallest]?.get(0)
                   //calculate new distance to neighboring node
                    val candidate= distances[smallest]?.plus(nextNode?.get("weight")?.toInt()!!)
                    val nextNeighbor=nextNode?.get("node")
                    if (candidate!! < distances[nextNeighbor]!!){
                        //Updating new smallest distance to neighbor
                        distances.put(nextNeighbor!!,candidate)
                        //Updating previous - How we got to neighbor
                        previous.put(nextNeighbor,smallest)
                        //enqueue in priority queue with new priority
                        nodes.enqueue(nextNeighbor,candidate)
                    }
                }
            }
        }
        return "$smallest ${path.reverse()}"
    }



}