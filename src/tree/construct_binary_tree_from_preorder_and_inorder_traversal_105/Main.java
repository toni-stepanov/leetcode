package tree.construct_binary_tree_from_preorder_and_inorder_traversal_105;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] inorder = {9,3,15,20,7};
        int[] preorder = {3,9,20,15,7};
        TreeNode root = s.buildTree(preorder, inorder);
        System.out.print(root);
    }
}
