package com.it.yousefl.dataalgo.da.trees

import java.util.*
import kotlin.collections.ArrayList

fun main() {

    val binarySearchTree=BinarySearchTree()
//    binarySearchTree.root= TreeNode(10)
//    binarySearchTree.root?.right=TreeNode(15)
//    binarySearchTree.root?.left= TreeNode(7)
//    binarySearchTree.root?.left?.right= TreeNode(9)

//    binarySearchTree.insert(10)
//    binarySearchTree.insert(5)
//    binarySearchTree.insert(2)
//    binarySearchTree.insert(7)
//    binarySearchTree.insert(13)
//    binarySearchTree.insert(11)
//    binarySearchTree.insert(16)
//    binarySearchTree.insert(16)
    binarySearchTree.insertRecursively(10, binarySearchTree.root)
    binarySearchTree.insertRecursively(6, binarySearchTree.root)
    binarySearchTree.insertRecursively(15, binarySearchTree.root)
    binarySearchTree.insertRecursively(3, binarySearchTree.root)
    binarySearchTree.insertRecursively(8, binarySearchTree.root)
    binarySearchTree.insertRecursively(20, binarySearchTree.root)
   // System.out.println(binarySearchTree.find(160))
  //  System.out.println(binarySearchTree.findRecursive(13,binarySearchTree.root))
  // System.out.println(binarySearchTree.breathFirstSearchIteratively())
   // System.out.println(binarySearchTree.depthFirstSearchPreOrder())
 //   System.out.println(binarySearchTree.depthFirstSearchPostOrder())
    System.out.println(binarySearchTree.depthFirstSearchInOrder())

}

class TreeNode<T>(var value: T){
    var left:TreeNode<T>?=null
    var right:TreeNode<T>?=null
}

class BinarySearchTree{
    var root:TreeNode<Int>?=null

    //       10
   //    5       13
  //   2   7   11  16
    fun insert(value: Int):BinarySearchTree?{
        val newNode=TreeNode(value)
        if (root==null){
            root=newNode
            return this
        }
        var current = root
            while (true){
                //handling duplicates
                if (value==current?.value){return null}
                //checking if the value is less than the current
                if (value < current!!.value){
                    //TODO:-Adding on the left
                    if (current.left==null){
                        current.left=newNode
                        return this
                    }
                    current = current.left
                //checking if the value is greater than the current
                }else if(value > current.value){
                    //TODO:-Adding on the right
                    if (current.right==null){
                        current.right=newNode
                        return  this
                    }
                    current=current.right
                }
            }

    }

    fun insertRecursively(value: Int, current: TreeNode<Int>?):BinarySearchTree?{
        val newNode=TreeNode(value)
        if (root==null){
            root=newNode
            return this
        }
        if (newNode.value < current!!.value){
            //TODO:-Adding in the left
            if (current.left==null){
                current.left=newNode
                return this
            }
           return insertRecursively(value, current.left)
        }else if(newNode.value > current.value){
            //TODO:-Adding in the right
            if (current.right==null){
                current.right=newNode
                return this
            }
            return insertRecursively(value, current.right)
        }
        return null
    }

    //It's for finding the node
    fun find(value: Int):Boolean?{
       val newNode=TreeNode(value)
        if (root==null) return null
        if (root?.value==newNode.value)return true

        var current=root
        while (current!=null){
            if(value <= current!!.value){
                //TODO:-Searching in the left
                if (value==current.value){
                    return true
                }
                current=current.left
            }else if(value >= current.value){
                //TODO:-Searching in the right
                if (value==current.value){
                    return true
                }
                current=current.right
            }
        }
        return false
    }

    fun findRecursive(value: Int, current: TreeNode<Int>?):Boolean?{
        if (current==null) {
            return null
        }
        if (current.value==value) {
            return true
        } else if(value < current.value) {
            //TODO:-Searching in the left
        return findRecursive(value, current.left)
        }else if(value > current.value){
            //TODO:-Searching in the right
        return findRecursive(value, current.right)
        }
     return false
    }

//TODO:-We can use Breadth-First search OR Depth-First Search  in any kind of Tree

    // ->          10
    // ->     6  ->     15
    // ->   3    8   ->    20
    fun breathFirstSearchIteratively():ArrayList<Int>{
        val list=ArrayList<Int>()
        val queue=LinkedList<TreeNode<Int>>()
        var current=root
        if (current==null)return list
        queue.add(current)
        //Q:[10]
        //List:[]
        while (queue.size!=0){
            current=queue.poll()
            list.add(current.value)
            //Q:[]
            // List:[10]
            if (current.left!=null){
                queue.add(current.left!!)
            }
            if (current.right!=null){
                queue.add(current.right!!)
            }
            //Q:[6,15]
            // List:[10]

        }
        return list  //TODO:-[10,6,15,3,8,20]
    }

    //            10
    //       6         15
    //    3     8          20   (root,left(all left side),right(all right side))
    fun depthFirstSearchPreOrder():ArrayList<Int>{
        val list=ArrayList<Int>()
        val current=root
        fun traverse(node: TreeNode<Int>){
           list.add(node.value)

            if (node.left!=null){
                traverse(node.left!!)
            }
            if (node.right!=null){
                traverse(node.right!!)
            }
        }
        current?.let { traverse(it) }
       return list //TODO:-[10,6,3,8,15,20]
    }

    //            10
    //       6         15
    //    3     8          20   (left,right,root)
    fun depthFirstSearchPostOrder():ArrayList<Int>{
        val list=ArrayList<Int>()
        val current=root
        fun traverse(node: TreeNode<Int>){
            if (node.left!=null){
                traverse(node.left!!)
            }
            if (node.right!=null){
                traverse(node.right!!)
            }
            list.add(node.value)
        }
        current?.let { traverse(it) }
        return list //TODO:-[3,8,6,20,15,10]
    }
    //            10
    //       6         15
    //    3     8          20   (left,root,right)
    fun depthFirstSearchInOrder():ArrayList<Int>{
        val list=ArrayList<Int>()
        val current=root
        fun traverse(node:TreeNode<Int>){
         if (node.left!=null){
             traverse(node.left!!)
         }
            list.add(node.value)
         if (node.right!=null){
             traverse(node.right!!)
         }
        }
        current?.let { traverse(it) }
        return list //TODO:-[3,6,8,10,15,20]
    }
}
