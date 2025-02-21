/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    // Let's create the ListNode class as private
    private class ListNode {
        int val;
        ListNode next;
        // ListNode() {}
        ListNode(int val) { this.val = val; }
        // ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    // Time complexity: O(n)
    // Space complexity: O(1)
    public ListNode reverseList(ListNode head) {
        // Creating the previous and current node
        ListNode prev = null, current = head;

        // Looping through the linked list
        while (current != null) {
            // Saving the next node
            ListNode next = current.next;
            // Reversing the current node
            current.next = prev;
            // Moving the previous and current node
            prev = current;
            current = next;
        }

        // Returning the reversed linked list
        return prev;
    }

    public static void main(String[] args) {
        // Creating the linked list
        ListNode head = new Solution().new ListNode(1);
        head.next = new Solution().new ListNode(2);
        head.next.next = new Solution().new ListNode(3);
        head.next.next.next = new Solution().new ListNode(4);
        head.next.next.next.next = new Solution().new ListNode(5);

        // Reversing the linked list
        ListNode reversed = new Solution().reverseList(head);

        // Printing the reversed linked list
        while (reversed != null) {
            System.out.print(reversed.val + " ");
            reversed = reversed.next;
        }
    }
}