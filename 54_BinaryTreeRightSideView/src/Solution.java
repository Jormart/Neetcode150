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
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        // List to store the right side view of the tree
        List<Integer> rightSideView = new ArrayList<>();
        // If the root is null, return the empty list
        if(root == null)
            return rightSideView;
        // Queue to store the nodes of the tree
        Queue<TreeNode> queue = new LinkedList<>();
        // Add the root to the queue
        queue.add(root);
        // Iterate until the queue is empty
        while(!queue.isEmpty())
        {
            // Get the size of the queue
            int size = queue.size();
            // Iterate over the nodes at the current level
            for(int i = 0; i < size; i++)
            {
                // Get the front node from the queue
                TreeNode node = queue.poll();
                // If it is the last node at the current level, add it to the right side view list
                if(i == size - 1)
                    rightSideView.add(node.val);
                // If the left child is not null, add it to the queue
                if(node.left != null)
                    queue.add(node.left);
                // If the right child is not null, add it to the queue
                if(node.right != null)
                    queue.add(node.right);
            }
        }
        // Return the right side view list
        return rightSideView;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = sol.new TreeNode(1);
        root.left = sol.new TreeNode(2);
        root.right = sol.new TreeNode(3);
        root.left.right = sol.new TreeNode(5);
        root.right.right = sol.new TreeNode(4);
        List<Integer> rightSideView = sol.rightSideView(root);
        System.out.println("Right side view of the tree: " + rightSideView);
    }
}