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
    // Create the Listnode private class
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Create the dummy node
        ListNode dummy = new ListNode(1);
        dummy.next = head; // dummy -> head
        // Create the two pointers front and back
        ListNode front = dummy;
        ListNode back = dummy;
        // Move the front pointer n+1 steps
        for (int i = 1; i <= n + 1; i++) {
            front = front.next;
        }
        // Move the front and back pointers until the front pointer reaches the end
        while (front != null) {
            front = front.next;
            back = back.next;
        }
        // Remove the nth node from the end
        back.next = back.next.next;
        // Return the head of the list
        return dummy.next;
    }

    public static void main(String[] args) {
        // Create the Solution object
        Solution solution = new Solution();

        // Create the list
        ListNode head = solution.new ListNode(1);
        head.next = solution.new ListNode(2);
        head.next.next = solution.new ListNode(3);
        head.next.next.next = solution.new ListNode(4);
        head.next.next.next.next = solution.new ListNode(5);

        // Remove the nth node from the end
        ListNode result = solution.removeNthFromEnd(head, 2);

        // Print the result
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}