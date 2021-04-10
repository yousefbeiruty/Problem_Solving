package com.it.yousefl.dataalgo.da.hashtable

fun main() {

    val hashTables=HashTables(17)
    hashTables.set("maroon","#800000")
    hashTables.set("yellow","#FFFF00")
    hashTables.set("olive","#808000")

    hashTables.set("salmon","#FA8072")
    hashTables.set("lightcoral","#F08080")
    hashTables.set("mediumvioletred","#C71585")

    hashTables.set("plum","#DDA0DD")

    hashTables.set("duplicate","#DDA0DD")


     System.out.println(hashTables.get("duplicate"))
      hashTables.values()
      hashTables.keys()

}


class HashTables(var size: Int){
    var keyMap = arrayOfNulls<ArrayList<String>>(size)
    fun hashKey(key: String): Int {
        var total = 0
        val WEIRD_PRIME = 31
        for (i in 0 until Math.min(key.length, 100)) {
            val value = key[i].toInt() - 96
            total = (total * WEIRD_PRIME + value) % keyMap.size
        }
        return Math.abs(total)
    }

    fun set(key: String, value: String): Int {
      val index=hashKey(key)
      //TODO:-[, ,[[key,value],] , ,]   we will use Separate Chaining (we check if the field is empty or not if is we put an array in it)
      // if there is we just put a ,inside the array and add anonther one [, ,[[key,value],[key2,value2]] , ,]
      if (keyMap[index]==null){
          keyMap.set(index,arrayListOf())
      }
        keyMap.set(index,arrayListOf(key, value))
        return index
    }

    fun get(key: String): String? {
        val index=hashKey(key)
        if (keyMap[index]!=null){

         for (i in 0 until (keyMap[index]?.size ?: 10)){
             if (keyMap[index]?.get(i).toString() == key){
                return keyMap[index]?.get(1)
             }
         }
        }
        return null
    }

    fun values():ArrayList<String>?{
        val arr= arrayListOf<String>()
        for (i in keyMap.indices){
            if (keyMap[i]!=null){
                for (j in 0 until (keyMap[i]?.size ?: 10)) {
                    if (!arr.contains(keyMap.get(i)?.get(1)))
                    arr.add(keyMap[i]?.get(1).toString())
                }
            }

        }
        System.out.println(arr)
        return arr
    }

    fun keys():ArrayList<String>?{
        val arr= arrayListOf<String>()
        for (i in 0 until (keyMap.size)){
            if (keyMap[i]!=null){
                for (j in 0 until keyMap[i]?.size!!) {
                    //     System.out.println(keyMap[i]?.get(1).toString())
                    if (!arr.contains(keyMap.get(i)?.get(0)))
                    arr.add(keyMap.get(i)?.get(0).toString())
                }
            }

        }
        System.out.println(arr)
        return arr
    }
}




