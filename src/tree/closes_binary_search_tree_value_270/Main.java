package tree.closes_binary_search_tree_value_270;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        int result = s.closestValue(root, 3.2);
        System.out.println(result);
    }
}
