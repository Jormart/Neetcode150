import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // Check the edge cases for the input
        if (nums == null || nums.length == 0 || k == 0) {
            return new int[0];
        }
        // Initialize the lenght and the result array
        int n = nums.length;
        int[] result = new int[n - k + 1];
        // Initialize the deque to store the index of the elements
        Deque<Integer> deque = new LinkedList<>();
        // Iterate through the array
        for (int i = 0; i < n; i++) {
            // Remove the elements from the front of the deque if the window size is greater
            // than k
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            // Remove the elements from the back of the deque if the current element is
            // greater than the last element
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            // Add the current element to the deque
            deque.offerLast(i);
            // Add the maximum element to the result array
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        int[] result = solution.maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(result));
    }
}