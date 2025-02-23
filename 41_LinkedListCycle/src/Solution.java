/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    // Definition of ListNode class with val and next
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        // If head is null, return false
        if (head == null) {
            return false;
        }
        // Initialize two pointers, slow and fast
        ListNode slow = head, fast = head.next;

        // Loop through the linked list until slow is equal to fast
        while (slow != null || fast != null) {
            // Move slow pointer by one step
            if (fast == null || fast.next == null) {
                return false;
            }
            if (slow == fast) {
                return true;
            }
            // Move fast pointer by two steps
            slow = slow.next;
            fast = fast.next.next;
        }

        // Return false if slow is not equal to fast
        return false;
    }

    public static void main(String[] args) {
        // Create a new Solution object
        Solution solution = new Solution();

        // Create a new ListNode object
        ListNode head = solution.new ListNode(3);
        head.next = solution.new ListNode(2);
        head.next.next = solution.new ListNode(0);
        head.next.next.next = solution.new ListNode(-4);
        head.next.next.next.next = head.next;

        // Call hasCycle method
        boolean result = solution.hasCycle(head);

        // Print the result
        System.out.println(result);
    }
}