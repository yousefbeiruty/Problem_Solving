package com.it.yousefl.dataalgo.da.hackerrank;

public class DuplicateCharactersInAString {

    public static void main(String[] args) {
        String s="aaaavbb";
       System.out.println(duplicate(s));
    }
    
    public static int duplicate(String s){
        String charcters="";
        String duplicates="";
        for(Character c:s.toCharArray()){
            String current =Character.toString(c);
            if(charcters.contains(current)){
               duplicates+=current;
            }
           charcters+=current;
        }
        return duplicates.length();
    }
}
