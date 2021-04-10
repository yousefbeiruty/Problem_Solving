package com.it.yousefl.dataalgo.da.recursion

fun main() {
    //countDown(3)
   // System.out.println(sumRange(3))
   // countDownIteratively(5)
    System.out.println(factorialRecursively(3))
}
/***-----------------Recursion----------------****/
/**When should I use recursion?
Recursion is made for solving problems that can be broken down into smaller,
repetitive problems. It is especially good for working on things that have many possible
branches and are too complex for an iterative approach.
One good example of this would be searching through a file system. You could start at
the root folder, and then you could search through all the files and folders within that one.
After that, you would enter each folder and search through each folder inside of that.

Recursion works well for this type of structure because you can search multiple branching paths without having to include many different checks and conditions for every possibility.
For those of you who are familiar with data structures, you might notice that the image above of the file system looks a lot like a tree structure.
Trees and graphs are another time when recursion is the best and easiest way to do traversal.


Should I always use recursion?
Recursion seems really useful! Maybe I should use it all the time?
Well, like anything, recursion is best in doses. Recursion is a useful tool,
but it can increase memory usage.
So let’s go back to the factorial call stack image from above. Every time we
add a new call to the stack, we are increasing the amount of memory that we are using.
If we are analyzing the algorithm using Big O notation, then we might note that this increases
our space complexity.
There are times when we might want to pay this cost in order to get a short,
useful algorithm, like when we are traversing a tree. But there are other times
when there may be better, more efficient ways of solving this problem.


For many small projects, the call stack won’t hamper you program very much.
However, once your program starts making many recursive calls, then you might
want to consider the potential impact of your large call stack.
 */
fun countDown(n: Int){
    System.out.println("---------------- Recursion ----------------------------")
    var num=n
    if(num<=0){
        System.out.println("All done!")
        return
    }
    System.out.println(num)
    num--
    countDown(num)
}

fun countDownIteratively(n: Int){
    System.out.println("---------------- Iteration ----------------------------")
    var num=n
    while (num>0){
        System.out.println(num)
        num--
    }
    System.out.println("All done!")
}


fun sumRange(num: Int): Int {
    System.out.println("---------------- Recursion ----------------------------")
    //3==1
    //2==1
    //1==1
    if (num==1){
        System.out.println("All done!")
        return 1
    }
    System.out.println(num)
    return num+ sumRange(num - 1)

    //       3  +      3   =6
    //return 3  + sumRange(2)
     //             2  +   1=3
    //       return 2  + sumRange(1)
    //                       return 1
}

fun factorialRecursively(n: Int): Int{
    var num=n
    if (num==1){
        return 1
    }
    return num* factorialRecursively(num - 1)
}

//!3---->3*2*1=6
fun factorialIteratively(n: Int): Int {
    var num=n
    var total=1
    while (num>0){
     total *=num
        num--
    }
    return total
}



/*********---------------------Helper Recursion----------------------------------**************/

//fun collectValues(arrayList: ArrayList<Int>){
//    val result=ArrayList<Int>();
//
//    fun helper(helperInput: ArrayList<Int>){
//        if (helperInput.size==0){
//            return
//        }
//
//        if (helperInput.get(0)%2 !=0)
//            result.add(helperInput.subList(1))
//    }
//}
//pow(2,0)=>1
//pow(2,2)=>4
fun pow(a: Int, n: Int): Int {
    //         0==0-->1
    //         2==0 ->No          2 *  pow(2,2-1)
    //         1==0->No           2 * pow(2,1-1)
    //         0==0->Yes
    return if (n == 0) { 1 } else a * pow(a, n - 1)
    //     2 *  pow(2,1) --->2*2=4
    //         2 * pow(2,0) --> 2*1=2
    //                1
}
