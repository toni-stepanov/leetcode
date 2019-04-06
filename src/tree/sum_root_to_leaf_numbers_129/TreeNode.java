package tree.sum_root_to_leaf_numbers_129;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    @Override
    public String toString() {

        String leftStr = this.left != null ? this.left.toString() : "NULL";
        String rightStr = this.right != null ? this.right.toString() : "NULL";
        return "ROOT: " + val + " LEFT: " + leftStr + " RIGHT: " + rightStr;
    }
}
