package com.it.yousefl.dataalgo.da.dynamicprogramming

fun main() {

    //TODO:-Fibonacci
    // *Fib(n)=Fib(n-1)+Fib(n-2)
    // *Fib(2) is 1
    // *Fib(1) is 1

    System.out.println(fib(5))


    System.out.println(fibTab(5))
}
//using Tabulation
fun fibTab(n: Int): Int {
    //TODO:-Time Complexity O(n)
    if(n<=2)return 1
    val fibNums= arrayOf<Int>(0,1,1)
    var i=3
    while ( i <= n){
        fibNums[i]=fibNums[i-1]+fibNums[i-2]
        i++
    }
    return fibNums[n]
}


//using memoization
fun fibMemo(n: Int): Int {

    //TODO:-Time Complexity O(n)  MEMOMISATION (Top to Bottom)
    val memo:Array<Int> = arrayOf()

    memo[1]=1
    memo[2]=1

    if (memo[n]!=null)return memo[n]
    if(n<=2)return 1

    val res= fibMemo(n - 1)+ fibMemo(n - 2)

    memo[n]=res
    return res
}

fun fib(n: Int): Int {
//TODO:-Time Complexity O(2^n)
    if(n<=2)return 1

    return fib(n - 1)+ fib(n - 2)
}

