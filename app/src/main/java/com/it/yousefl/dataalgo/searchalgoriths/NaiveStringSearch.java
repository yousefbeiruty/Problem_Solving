package com.it.yousefl.dataalgo.searchalgoriths;

import org.jetbrains.annotations.NotNull;

public class NaiveStringSearch {
    public static void main(String[] args) {
        //  System.out.println(naiveStringSearch("harold said haha in hamburg","in"));
        System.out.println(naiveStringSearch("lorie loled","lol"));
    }

    /**-----------------Naive String search-------------*/
/**Ex:-Search for a substring in a larger string:-
 * "harold said haha in hamburg"
 * serach for "haha"
 *
 * */
//"harold said haha in hamburg"             "said"

    public static int naiveStringSearch(String largerString, String subString){
       int count=0;
        for (int i=0;i<largerString.length();i++){
            for (int j=0;j<subString.length();j++){
                if (subString.charAt(j)!=largerString.charAt(i+j)){
                    break;
                }
                if (j==subString.length()-1) {
                    System.out.println("find one");
                    count++;
                }
            }
        }
        return count;
    }
}
