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
    public class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val)
        {
            this.val = val;
        }
    }

    // Global variable to store the list of elements in the tree
    List<Integer> elements = new ArrayList<>();

    // Function to perform inorder traversal of the tree
    public void inorder(TreeNode root)
    {
        if(root == null)
        {
            return;
        }
        inorder(root.left);
        elements.add(root.val);
        inorder(root.right);
    }

    public int kthSmallest(TreeNode root, int k) {
        // Perform inorder traversal of the tree
        inorder(root);
        // Return the kth element from the list
        return elements.get(k-1);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = sol.new TreeNode(3);
        root.left = sol.new TreeNode(1);
        root.right = sol.new TreeNode(4);
        root.left.right = sol.new TreeNode(2);
        System.out.println("Kth Smallest Element: " + sol.kthSmallest(root, 1));
    }
}