package tree.construct_binary_tree_from_inorder_and_postorder_traversal_106;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] inorder = {3,2,1};
        int[] postorder = {3,2,1};
        TreeNode root = s.buildTree(inorder, postorder);
        System.out.print(root);
    }
}


