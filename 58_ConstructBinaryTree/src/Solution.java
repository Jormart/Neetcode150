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
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Definition of preorder index and hashmap to store inorder index
    int preIndex = 0;
    Map<Integer, Integer> inorderIndexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Initialize the preorder index and the inorder index map
        preIndex = 0;
        inorderIndexMap = new HashMap<>();

        // Fill the inorder index map
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        // Build the tree from the preorder array
        return arrayToTree(preorder, 0, preorder.length - 1);
    }

    // Helper function to build the tree from the preorder array
    public TreeNode arrayToTree(int[] preorder, int left, int right) {
        // Base case
        if (left > right) {
            return null;
        }

        // Get the root node from the preorder array
        int rootValue = preorder[preIndex++];
        TreeNode root = new TreeNode(rootValue);

        // Get the index of the root node in the inorder array
        int inorderIndex = inorderIndexMap.get(rootValue);

        // Build the left and right subtrees
        root.left = arrayToTree(preorder, left, inorderIndex - 1);
        root.right = arrayToTree(preorder, inorderIndex + 1, right);

        return root;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode root = sol.buildTree(preorder, inorder);
        System.out.println(root.val);
    }
}