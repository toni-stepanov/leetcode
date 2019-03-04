package tree.same_tree_100;

/**
 100. Same Tree
 https://leetcode.com/problems/same-tree/

 Given two binary trees, write a function to check if they are the same or not.

 Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 */
public class Solution {

    boolean isSameTree(TreeNode p, TreeNode q) {
        if  (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return q.val == p.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}