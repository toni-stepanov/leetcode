package tree.merge_two_binary_trees_617;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.left.right.left = new TreeNode(10);

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(1);

        TreeNode result = s.mergeTrees(root, root1);
        System.out.print(result);
    }
}
