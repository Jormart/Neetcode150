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
    public class TreeNode {
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

    public boolean isBalanced(TreeNode root) {
        // Base case for the recursion
        if (root == null) {
            return true;
        }

        // Get the height of the left and right subtrees
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        
        // Check if the height difference is greater than 1
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }

        // Recursively check if the left and right subtrees are balanced
        return isBalanced(root.left) && isBalanced(root.right);
    }

    // Helper function to get the height of the tree
    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = sol.new TreeNode(3);
        root.left = sol.new TreeNode(9);
        root.right = sol.new TreeNode(20);
        root.right.left = sol.new TreeNode(15);
        root.right.right = sol.new TreeNode(7);

        System.out.println(sol.isBalanced(root));
    }
}