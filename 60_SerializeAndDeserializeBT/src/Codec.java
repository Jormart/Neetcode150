import java.util.*;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Treenode class to store the value and the left and right child
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Helper method to convert the tree to string using preorder traversal
    private void recSerialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null").append(",");
            return;
        }
        sb.append(root.val).append(",");
        recSerialize(root.left, sb);
        recSerialize(root.right, sb);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        recSerialize(root, sb);
        return sb.toString();
    }

    // Helper method to convert the string to tree using preorder traversal
    // We use a queue to store the values and then recursively build the tree
    private TreeNode recDeserialize(Queue<String> q) {
        String val = q.poll();
        if (val.equals("null")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = recDeserialize(q);
        root.right = recDeserialize(q);
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // Split the string by comma and store it in a queue
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        return recDeserialize(q);
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode root = codec.new TreeNode(1);
        root.left = codec.new TreeNode(2);
        root.right = codec.new TreeNode(3);
        root.right.left = codec.new TreeNode(4);
        root.right.right = codec.new TreeNode(5);
        String serialized = codec.serialize(root);
        System.out.println(serialized);
        TreeNode deserialized = codec.deserialize(serialized);
        System.out.println(deserialized.val);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));