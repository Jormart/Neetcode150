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
    public int goodNodes(TreeNode root) {
        // Call the helper method with the root and the minimum value
        return countGoodNodes(root, Integer.MIN_VALUE);
    }

    // Helper method to count the number of good nodes in the binary tree
    private int countGoodNodes(TreeNode root, int max) {
        // If the root is null, return 0
        if (root == null) {
            return 0;
        }
        // Initialize the count to 0
        int count = 0;
        // If the value of the root is greater than or equal to the max value
        if (root.val >= max) {
            // Increment the count
            count++;
            // Update the max value to the value of the root
            max = root.val;
        }
        // Recursively call the helper method for the left and right children
        count += countGoodNodes(root.left, max);
        count += countGoodNodes(root.right, max);
        // Return the count
        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = sol.new TreeNode(3);
        root.left = sol.new TreeNode(1);
        root.right = sol.new TreeNode(4);
        root.left.left = sol.new TreeNode(3);
        root.right.left = sol.new TreeNode(1);
        root.right.right = sol.new TreeNode(5);
        System.out.println("Number of good nodes: " + sol.goodNodes(root));
    }
}