package tree.inorder_successor_bst_285_;

/**
 * 285. Inorder Successor in BST
 * https://leetcode.com/problems/inorder-successor-in-bst/#/description
 * <p>
 * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 * <p>
 * Note: If the given node has no in-order successor in the tree, return null.
 * <p>
 * http://algorithms.tutorialhorizon.com/inorder-successor-in-binary-tree/
 * What is Inorder Suc­ces­sor: Inorder suc­ces­sor of a node is the next node in the inorder tra­ver­sal
 * of the tree. For the last node in a tree, inorder suc­ces­sor will be NULL
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

    TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null)
            return null;
        if (root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        } else {
            TreeNode left = inorderSuccessor(root.left, p);
            return (left != null) ? left : root;
        }
    }
}