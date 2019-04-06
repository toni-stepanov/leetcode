package tree.inorder_successor_bst_285_;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(4);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(10);
        TreeNode t = s.inorderSuccessor(root, root);
        System.out.print(t);
    }
}
