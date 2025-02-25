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
class Solution {
    // Definition for singly-linked list node
    private class ListNode {
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

    // Time: O(n)
    // Space: O(1)
    public ListNode reverseKGroup(ListNode head, int k) {
        // Create a dummy node to point to the head of the list
        ListNode dummy = new ListNode(0);
        // Connect the dummy node to the head of the list
        dummy.next = head;
        // Create a pointer to the previous node
        ListNode prev = dummy;

        // Loop through the list until the end
        while (head != null) {
            ListNode tail = prev;
            // Check if there are k nodes to reverse
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return dummy.next;
                }
            }

            // Save the next node after the k nodes
            ListNode next = tail.next;
            // Reverse the k nodes in the list
            ListNode[] reversed = reverse(head, tail);
            head = reversed[0];
            tail = reversed[1];

            // Connect the reversed nodes to the list
            prev.next = head;
            tail.next = next;

            // Move the pointers to the next k nodes
            prev = tail;
            head = tail.next;
        }

        return dummy.next; // Return the new head
    }

    // Helper function to reverse k nodes in the list
    private ListNode[] reverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode curr = head;
        while (prev != tail) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return new ListNode[] { tail, head };
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = solution.new ListNode(1);
        head.next = solution.new ListNode(2);
        head.next.next = solution.new ListNode(3);
        head.next.next.next = solution.new ListNode(4);
        head.next.next.next.next = solution.new ListNode(5);
        ListNode result = solution.reverseKGroup(head, 2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

}