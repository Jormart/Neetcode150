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
    // Definition for a binary tree node.
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

    // Helper method to check if two trees are equal
    public boolean areEqual(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }
        // Check if the current node is equal and the left and right subtrees are equal
        return root.val == subRoot.val && areEqual(root.left, subRoot.left) && areEqual(root.right, subRoot.right);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // Base case
        if (root == null) {
            return false;
        }

        // Check if the current tree is equal to the subtree
        if (areEqual(root, subRoot)) {
            return true;
        }

        // Check if the subtree is present in the left or right subtree
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = sol.new TreeNode(3);
        root.left = sol.new TreeNode(4);
        root.right = sol.new TreeNode(5);
        root.left.left = sol.new TreeNode(1);
        root.left.right = sol.new TreeNode(2);
        TreeNode subRoot = sol.new TreeNode(4);
        subRoot.left = sol.new TreeNode(1);
        subRoot.right = sol.new TreeNode(2);
        System.out.println("Test: " + sol.isSubtree(root, subRoot));
    }
}