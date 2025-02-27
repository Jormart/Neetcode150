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

    public boolean isSameTree(TreeNode p, TreeNode q) {
         // p and q are both null
        if (p == null && q == null) {
            return true;
        }
        // one of p and q is null
        if (q == null || p == null) {
            return false;
        }
        // compare the values of p and q. If the values are different, return false.
        if (p.val != q.val) {
          return false;
        }

        // Compare recursively the left and right subtrees of p and q.
        return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode p = s.new TreeNode(1);
        p.left = s.new TreeNode(2);
        p.right = s.new TreeNode(3);
        TreeNode q = s.new TreeNode(1);
        q.left = s.new TreeNode(2);
        q.right = s.new TreeNode(3);
        System.out.println(s.isSameTree(p, q)); // true
    }
}