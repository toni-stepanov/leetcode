package tree.binary_tree_upside_down_156_;

/**
 156. Binary Tree Upside Down
 https://leetcode.com/problems/binary-tree-upside-down/#/description

 Given a binary tree where all the right nodes are either leaf nodes
 with a sibling (a left node that shares the same parent node) or empty,
 flip it upside down and turn it into a tree where the original right
 nodes turned into left leaf nodes. Return the new root.

 For example:
 Given a binary tree {1,2,3,4,5},
 1
 / \
 2   3
 / \
 4   5
 return the root of the binary tree [4,5,2,#,#,3,1].
 4
 / \
 5   2
 / \
 3   1
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
    private TreeNode newRoot;

    // time O(n), Space O(1)
    TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode p = root, parent = null, parentRight = null;
        while (p != null) {
            TreeNode left = p.left;
            TreeNode right = p.right;
            p.left = parentRight;
            p.right = parent;
            parent = p;
            parentRight = right;
            p = left;
        }
        return parent;
    }
}