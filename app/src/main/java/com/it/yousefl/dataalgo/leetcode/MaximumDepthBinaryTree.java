package com.it.yousefl.dataalgo.leetcode;

import com.it.yousefl.dataalgo.trees.TreeNode;

public class MaximumDepthBinaryTree {


    public static void main(String[] args) {
        /**
         *
         * Given the root of a binary tree, return its maximum depth.
         *
         * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
         *
         *
         *
         * Example 1:
         *       3
         *     /   \
         *    9    20
         *        /   \
         *      15     7
         * Input: root = [3,9,20,null,null,15,7]
         * Output: 3
         * */
    }
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */

    public int maxDepth(TreeNode root) {
        if(root==null) return 0;

          int left=maxDepth(root.getLeft());
          int right=maxDepth(root.getRight());

          return Math.max(left,right)+1;

          //TODO:- how many levels:-
        //                 3         ----->1
        //         *     /   \
        //         *    9    20      ------>2
        //         *        /   \
        //         *      15     7   ------>3
    }
}
