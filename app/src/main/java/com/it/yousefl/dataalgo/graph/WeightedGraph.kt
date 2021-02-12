package com.it.yousefl.dataalgo.graph

fun main() {
val graph=WeightedGraph()
    graph.addVertex("A")
    graph.addVertex("B")
    graph.addVertex("C")
//    graph.addVertex("D")
//    graph.addVertex("E")
//    graph.addVertex("F")


    System.out.println( graph.addEdge("A","B","10"))
    System.out.println( graph.addEdge("A","C","5"))
    System.out.println( graph.addEdge("B","C","7"))


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

}