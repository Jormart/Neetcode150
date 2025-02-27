/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // If both p and q are greater than root, then LCA lies on the right side
        int parentVal = root.val;
        int pVal = p.val;
        int qVal = q.val;

        // If both p and q are greater than parent
        if (pVal > parentVal && qVal > parentVal) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (pVal < parentVal && qVal < parentVal) {
            return lowestCommonAncestor(root.left, p, q);
        } else return root; // If p and q are on different sides of the parent
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = s.new TreeNode(6);
        root.left = s.new TreeNode(2);
        root.right = s.new TreeNode(8);
        root.left.left = s.new TreeNode(0);
        root.left.right = s.new TreeNode(4);
        root.right.left = s.new TreeNode(7);
        root.right.right = s.new TreeNode(9);
        root.left.right.left = s.new TreeNode(3);
        root.left.right.right = s.new TreeNode(5);

        TreeNode p = root.left;
        TreeNode q = root.right;
        TreeNode result = s.lowestCommonAncestor(root, p, q);
        System.out.println(result.val);
    }
}