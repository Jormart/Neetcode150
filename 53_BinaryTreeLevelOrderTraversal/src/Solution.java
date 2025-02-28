import java.util.*;
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

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Global variable to store the result
    List<List<Integer>> result = new ArrayList<>();

    // Helper function to perform the level order traversal
    public void orderTraversal(TreeNode node, int level) {
        // If the root is null, return
        if (node == null) {
            return;
        }

        // If the result size is equal to the level, add a new list
        if (result.size() == level) {
            result.add(new ArrayList<>());
        }

        // Add the value to the list at the level
        result.get(level).add(node.val);

        // Recursively call the left and right children
        orderTraversal(node.left, level + 1);
        orderTraversal(node.right, level + 1);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        // Call the helper function with the root and level 0
        orderTraversal(root, 0);

        // Return the result
        return result;
    }
}