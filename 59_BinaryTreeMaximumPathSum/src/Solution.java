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
    // Definition of a global variable to store the maximum path sum
    private int maxSum = Integer.MIN_VALUE;

    // Definition of a helper function to calculate the maximum path sum
    private int maxGain(TreeNode root) {
        // Base case: if the root is null, return 0
        if (root == null) {
            return 0;
        }

        // Recursively calculate the maximum path sum for the left and right subtrees
        int left = Math.max(0, maxGain(root.left));
        int right = Math.max(0, maxGain(root.right));

        // Update the maximum path sum
        maxSum = Math.max(maxSum, root.val + left + right);

        // Return the maximum path sum for the current subtree
        return root.val + Math.max(left, right);
    }

    public int maxPathSum(TreeNode root) {
        // Call the helper function to calculate the maximum path sum
        maxGain(root);

        // Return the maximum path sum
        return maxSum;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = sol.new TreeNode(1);
        root.left = sol.new TreeNode(2);
        root.right = sol.new TreeNode(3);
        System.out.println(sol.maxPathSum(root)); // Output: 6
    }
}