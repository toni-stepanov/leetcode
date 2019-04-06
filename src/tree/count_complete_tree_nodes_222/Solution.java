package tree.count_complete_tree_nodes_222;

/**
 * 222. Count Complete Tree Nodes
 * https://leetcode.com/problems/count-complete-tree-nodes/?tab=Description
 * <p>
 * Given a complete binary tree, count the number of nodes.
 * <p>
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last,
 * if completely filled, and all nodes in the last level are as far
 * left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 * <p>
 * https://en.wikipedia.org/wiki/Binary_tree#Types_of_binary_trees
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    // Good solutions
    // https://discuss.leetcode.com/topic/18508/accepted-clean-java-solution/2 - good description.
    // https://discuss.leetcode.com/topic/49942/beating-99-84-submissions-in-c-quite-intuitive-and-well-commented/2 - second one.
    // https://discuss.leetcode.com/topic/21317/accepted-easy-understand-java-solution\
    // Time complexity O(log n), space complexity O(1)
    // The idea is simple, if the height of left sub tree is the same to the right sub tree, we know that left sub tree is a full binary tree, so the total count of the nodes in left sub tree plus the root node is 2^h where h is the height of left sub tree, then we just need to count the nodes in right sub tree.
    // The bit manipulation in this code is doing the calculation of 2^h.
    int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        int hLeft = getHeight(root.left);
        int hRight = getHeight(root.right);
        if (hLeft == hRight)
            return (1 << hLeft) + countNodes(root.right);
        else
            return (1 << hRight) + countNodes(root.left);
    }

    int countNodes2(TreeNode root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    /**
     * Go to bottom of the tree by left side.
     * So right side can be smaller.
     *
     * @param node node
     * @return height
     */
    private int getHeight(TreeNode node) {
        if (node == null) return 0;
        int height = 0;
        while (node != null) {
            node = node.left;
            height++;
        }
        return height;
    }
}