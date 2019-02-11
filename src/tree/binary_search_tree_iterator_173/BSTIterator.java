package tree.binary_search_tree_iterator_173;

import java.util.Stack;
/**
 173. Binary Search Tree Iterator
 https://leetcode.com/problems/binary-search-tree-iterator/

 Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

 Calling next() will return the next smallest number in the BST.

 Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 */

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {

    private Stack<TreeNode> stack = new Stack<>();

    BSTIterator(TreeNode root) {
        pushLeftBrunch(root);
    }

    /** @return whether we have a next smallest number */
    boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        if (!hasNext()) return 0;
        TreeNode current = stack.pop();
        if (current.right != null) pushLeftBrunch(current.right);
        return current.val;
    }

    private void pushLeftBrunch(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }
}

/*
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */