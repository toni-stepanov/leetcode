package tree.minimum_depth_binary_tree_111;

/**
 111. Minimum Depth of Binary Tree
 https://leetcode.com/problems/minimum-depth-of-binary-tree/

 Given a binary tree, find its minimum depth.
 The minimum depth is the number of nodes along the shortest path
 from the root node down to the nearest leaf node.
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
   int minDepth(TreeNode root) {
        if (root == null) return 0;
        int l = minDepth(root.left);
        int r = minDepth(root.right);
        // (l==0 || r==0) - if node has 0 or 1 child - return child depth+1;
        // !(l==0 || r==0) - node has two children, return min from them +1.
        return (l==0 || r==0) ? l+r+1 : Math.min(l,r) + 1;
    }
}