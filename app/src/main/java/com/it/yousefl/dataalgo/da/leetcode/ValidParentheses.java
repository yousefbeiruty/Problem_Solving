package com.it.yousefl.dataalgo.da.leetcode;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {

    }

    /**
     * Given a string s containing just the characters
     * '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     * <p>
     * An input string is valid if:
     * <p>
     * Open brackets must be closed by the same type of brackets.
     * Open brackets must be closed in the correct order.
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: s = "()"
     * Output: true
     * Example 2:
     * <p>
     * Input: s = "()[]{}"
     * Output: true
     * Example 3:
     * <p>
     * Input: s = "(]"
     * Output: false
     * Example 4:
     * <p>
     * Input: s = "([)]"
     * Output: false
     * Example 5:
     * <p>
     * Input: s = "{[]}"
     * Output: true
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (Character c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' && !stack.isEmpty() && stack.peek()=='(') {
                stack.pop();
            }else if (c == ']' && !stack.isEmpty() && stack.peek()=='[') {
                stack.pop();
            }else if (c == '}' && !stack.isEmpty() && stack.peek()=='{') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }


}
