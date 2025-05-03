// Problem: Longest Increasing Subsequence
// Difficulty: Medium
// Tags: Dynamic Programming, Binary Search

import java.util.Arrays;

class Solution {
    // Approach: Dynamic Programming
    // Time Complexity: O(n^2)
    // Space Complexity: O(n)
    // Explanation: We maintain a `dp` array where `dp[i]` is the length of the
    // longest increasing subsequence ending at index `i`.
    // For each number in `nums`, we check all previous numbers and update the
    // `dp` array accordingly.
    // The length of the longest increasing subsequence is the maximum value in the
    // `dp` array at the end.

    public int _lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int maxLength = 1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }

    // Approach: Dynamic Programming with Binary Search
    // Time Complexity: O(n log n)
    // Space Complexity: O(n)
    // Explanation: We maintain an array `dp` where `dp[i]` is the smallest tail of
    // all increasing subsequences of length `i+1`.
    // For each number in `nums`, we use binary search to find its position in `dp`
    // and update it accordingly.
    // The length of the longest increasing subsequence is the length of the `dp`
    // array at the end.
    // Note: This approach is more efficient than the O(n^2) dynamic programming
    // solution.

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int length = 0;

        for (int num : nums) {
            int left = 0, right = length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (dp[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            dp[left] = num;
            if (left == length) {
                length++;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
        System.out.println(solution.lengthOfLIS(nums)); // Output: 4
    }

}