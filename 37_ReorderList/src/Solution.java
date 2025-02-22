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

    // Create a Listnode private class
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

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public void reorderList(ListNode head) {
        // Check if the head is null
        if (head == null) {
            return;
        }

        // Find the middle of the list
        ListNode slow = head, fast = head;
        // Find the middle of the list
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // Reverse the second half of the list
        ListNode prev = null, curr = slow, temp = null;
        while (curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        // Merge the two lists
        ListNode first = head, second = prev;
        while (second.next != null) {
            temp = first.next;
            first.next = second;
            first = temp;
            temp = second.next;
            second.next = first;
            second = temp;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = solution.new ListNode(1);
        head.next = solution.new ListNode(2);
        head.next.next = solution.new ListNode(3);
        head.next.next.next = solution.new ListNode(4);
        head.next.next.next.next = solution.new ListNode(5);
        solution.reorderList(head);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}