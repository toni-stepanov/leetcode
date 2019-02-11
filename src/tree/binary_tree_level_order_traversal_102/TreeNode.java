package tree.binary_tree_level_order_traversal_102;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    @Override
    public String toString() {
        if (this == null) return "NULL";
        String leftStr = this.left != null ? this.left.toString() : "NULL";
        String rightStr = this.right != null ? this.right.toString() : "NULL";
        return "ROOT: " + val + " LEFT: " + leftStr + " RIGHT: " + rightStr;
    }
}
