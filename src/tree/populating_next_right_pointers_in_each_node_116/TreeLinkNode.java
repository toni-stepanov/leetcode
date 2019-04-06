package tree.populating_next_right_pointers_in_each_node_116;

public class TreeLinkNode {
    int val;
    TreeLinkNode left;
    TreeLinkNode right;
    TreeLinkNode next;
    TreeLinkNode(int x) { val = x; }

    @Override
    public String toString() {

        String leftStr = this.left != null ? this.left.toString() : "NULL";
        String rightStr = this.right != null ? this.right.toString() : "NULL";
        String nextStr = this.next != null ? this.next.toString() : "NULL";
        return "ROOT: " + val + " LEFT: " + leftStr + " RIGHT: " + rightStr + " NEXT: " + nextStr;
    }
}
