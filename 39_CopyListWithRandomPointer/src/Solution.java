import java.util.*;

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Solution {

    // HashMap which holds old nodes as keys and new nodes as its values.
    HashMap<Node, Node> visitedNode = new HashMap<Node, Node>();

    public Node copyRandomList(Node head) {
        // If the linked list is empty then you don't need to do anything, so return
        // null.
        if (head == null) {
            return null;
        }
        // If we have already processed the current node, then we simply return the
        // cloned version of it.
        if (this.visitedNode.containsKey(head)) {
            return this.visitedNode.get(head);
        }
        // Create a new node with the value same as old node. (i.e. copy the node)
        Node node = new Node(head.val);
        // Save this value in the hash map. This is needed since there might be
        // cycles during traversal.
        this.visitedNode.put(head, node);
        // Recursively copy the remaining linked list starting once from the next
        // pointer and then from the random pointer.
        // Thus we have two independent recursive calls.
        node.next = this.copyRandomList(head.next);
        // Finally we update the next and random pointers for the new node created.
        node.random = this.copyRandomList(head.random);

        return node; // Return the cloned linked list.
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        Node head = new Node(7);
        head.next = new Node(13);
        head.next.next = new Node(11);
        head.next.next.next = new Node(10);
        head.next.next.next.next = new Node(1);

        head.next.random = head;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head;

        Node result = sol.copyRandomList(head);
        System.out.println(result.val);
    }
}