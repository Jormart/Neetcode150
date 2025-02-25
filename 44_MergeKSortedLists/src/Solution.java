import java.util.*;

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
    // Define the Listnode class to store the value and the next node
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

    // Time complexity: O(nlogn)
    // Space complexity: O(n)
    // public ListNode mergeKLists(ListNode[] lists) {
    // // Defininig the priority queue to store the values
    // PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    // // Adding the values to the priority queue
    // for (ListNode head : lists) {
    // while (head != null) {
    // minHeap.add(head.val);
    // head = head.next;
    // }
    // }
    // // Creating a dummy node to store the values
    // ListNode dummy = new ListNode(1);
    // // Creating a merge node to store the values
    // ListNode merge = dummy;
    // // Adding the values to the linked list
    // while (!minHeap.isEmpty()) {
    // merge.next = new ListNode(minHeap.remove());
    // merge = merge.next;
    // }

    // return dummy.next; // Returning the next node of the dummy node
    // }

    public ListNode mergeKLists(ListNode[] lists) {
        // Defining the priority queue (min-heap) to store the nodes
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new Comparator<ListNode>() {
            public int compare(ListNode l1, ListNode l2) {
                return Integer.compare(l1.val, l2.val);
            }
        });

        // Initializing the heap with the head nodes of each list
        for (ListNode head : lists) {
            if (head != null) {
                minHeap.offer(head);
            }
        }

        // Dummy node to help with the result list
        ListNode dummy = new ListNode(-1);
        ListNode merge = dummy;

        // Process the heap
        while (!minHeap.isEmpty()) {
            // Get the smallest node from the heap
            ListNode current = minHeap.poll();
            merge.next = current;
            merge = merge.next;

            // If the current node has a next node, push it into the heap
            if (current.next != null) {
                minHeap.offer(current.next);
            }
        }

        // Return the merged list (next of the dummy node)
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode l1 = sol.new ListNode(1);
        l1.next = sol.new ListNode(4);
        l1.next.next = sol.new ListNode(5);

        ListNode l2 = sol.new ListNode(1);
        l2.next = sol.new ListNode(3);
        l2.next.next = sol.new ListNode(4);

        ListNode l3 = sol.new ListNode(2);
        l3.next = sol.new ListNode(6);

        ListNode[] lists = { l1, l2, l3 };
        ListNode result = sol.mergeKLists(lists);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}