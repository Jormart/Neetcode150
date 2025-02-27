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
    public TreeNode invertTree(TreeNode root) {
        // Check if root is null
        if (root == null) {
            return null;
        }

        // Recursively invert the left and right nodes
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        // Swap left and right nodes
        root.left = right;
        root.right = left;
        
        return root; // Return the root
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = sol.new TreeNode(4);
        root.left = sol.new TreeNode(2);
        root.right = sol.new TreeNode(7);
        root.left.left = sol.new TreeNode(1);
        root.left.right = sol.new TreeNode(3);
        root.right.left = sol.new TreeNode(6);
        root.right.right = sol.new TreeNode(9);
        TreeNode invertedRoot = sol.invertTree(root);
        System.out.println(invertedRoot.val);
        System.out.println(invertedRoot.left.val);
        System.out.println(invertedRoot.right.val);
        System.out.println(invertedRoot.left.left.val);
        System.out.println(invertedRoot.left.right.val);
        System.out.println(invertedRoot.right.left.val);
        System.out.println(invertedRoot.right.right.val);
    }
}