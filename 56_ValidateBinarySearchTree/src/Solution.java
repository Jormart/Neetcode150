/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Global variable to store the previous node in the inorder traversal
    private TreeNode prev;

    // Function to perform inorder traversal of the binary tree
    private boolean inorder(TreeNode root)
    {
        // If the root is null, return true
        if (root == null)
            return true;

        // Traverse the left subtree
        if (!inorder(root.left))
            return false;

        // If the current node's value is less than the previous node's value, return false
        if (prev != null && root.val <= prev.val)
            return false;

        // Update the previous node
        prev = root;

        // Traverse the right subtree
        return inorder(root.right);
    }

    public boolean isValidBST(TreeNode root) {
        // Initialize the previous node as null
        prev = null;

        // Perform inorder traversal
        return inorder(root);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = sol.new TreeNode(2);
        root.left = sol.new TreeNode(1);
        root.right = sol.new TreeNode(3);
        System.out.println(sol.isValidBST(root)); // Output: true

        root = sol.new TreeNode(5);
        root.left = sol.new TreeNode(1);
        root.right = sol.new TreeNode(4);
        root.right.left = sol.new TreeNode(3);
        root.right.right = sol.new TreeNode(6);
        System.out.println(sol.isValidBST(root)); // Output: false
    }
}