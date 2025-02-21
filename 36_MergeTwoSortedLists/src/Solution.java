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
    // Define ListNode as private class
    private class ListNode {
        int val;
        ListNode next;
        // ListNode() {}
        ListNode(int val) { this.val = val; }
        // ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // Time complexity: O(n)
    // Space complexity: O(1)
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a dummy node
        ListNode dummy = new ListNode(1);
        // Create a pointer to dummy node
        ListNode merge = dummy;

        // Loop through both lists
        while (list1 != null && list2 != null) {
            // If list1 value is less than list2 value
            if (list1.val < list2.val) {
                // Add list1 value to merge list
                merge.next = list1;
                // Move list1 pointer to next node
                list1 = list1.next;
            } else {
                // Add list2 value to merge list
                merge.next = list2;
                // Move list2 pointer to next node
                list2 = list2.next;
            }
            // Move merge pointer to next node
            merge = merge.next;
        }

        // Update merge pointer to the list that is not null
        if(merge.next == list1 && list1 == null) {
            merge.next = list2;
        } else {
            merge.next = list1;
        }
        // Return the next node of dummy node
        return dummy.next;
    }

    public static void main(String[] args) {
        // Create a new instance of Solution class
        Solution solution = new Solution();
        // Create a new ListNode with value 1
        ListNode list1 = solution.new ListNode(1);
        // Add a new ListNode with value 2 to list1
        list1.next = solution.new ListNode(2);
        // Add a new ListNode with value 4 to list1
        list1.next.next = solution.new ListNode(4);

        // Create a new ListNode with value 1
        ListNode list2 = solution.new ListNode(1);
        // Add a new ListNode with value 3 to list2
        list2.next = solution.new ListNode(3);
        // Add a new ListNode with value 4 to list2
        list2.next.next = solution.new ListNode(4);

        // Merge list1 and list2
        ListNode merge = solution.mergeTwoLists(list1, list2);

        // Print the merged list
        while (merge != null) {
            System.out.print(merge.val + " ");
            merge = merge.next;
        }
    }
}