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

    // Global variable to keep track of the diameter of the binary tree
    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        // Calculate the height of the binary tree
        getHeight(root);

        // Return the diameter of the binary tree
        return maxDiameter;

    }

    // Helper function to calculate the height of the binary tree
    private int getHeight(TreeNode root) {
        // Base case: If the root is null, return 0
        if (root == null) {
            return 0;
        }

        // Recursively calculate the height of the left subtree
        int leftHeight = getHeight(root.left);

        // Recursively calculate the height of the right subtree
        int rightHeight = getHeight(root.right);

        // Update the diameter of the binary tree if the sum of the heights of the left and right subtrees is greater than the current diameter
        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);

        // Return the height of the current node 
        return 1 + Math.max(leftHeight, rightHeight); 
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test the example case
        TreeNode root = solution.new TreeNode(1);
        root.left = solution.new TreeNode(2);
        root.right = solution.new TreeNode(3);
        root.left.left = solution.new TreeNode(4);
        root.left.right = solution.new TreeNode(5);
        System.out.println(solution.diameterOfBinaryTree(root)); // Output: 3
    }
}