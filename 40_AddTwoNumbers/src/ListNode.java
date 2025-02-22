/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Create a dummy node to hold the result (placeholder)
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        // Traverse both lists until we reach the end of both
        while (l1 != null || l2 != null || carry != 0) {
            // If the current node is not null, get the value of the node
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            // Calculate the sum of the two nodes and the carry
            int sum = x + y + carry;
            carry = sum / 10;
            // Create a new node with the value of the sum
            current.next = new ListNode(sum % 10);
            current = current.next;
            // Move to the next node in both lists
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }

        // Return the next node of the dummy node
        return dummy.next;
    }

    public static void main(String[] args) {
        // Create the first list
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        // Create the second list
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        // Create a new instance of the solution
        Solution solution = new Solution();
        // Call the addTwoNumbers method
        ListNode result = solution.addTwoNumbers(l1, l2);

        // Print the result
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}