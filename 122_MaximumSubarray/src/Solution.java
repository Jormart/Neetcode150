// 53. Maximum Subarray
// https://leetcode.com/problems/maximum-subarray/
class Solution {
    // Greedy solution using divide and conquer
    // Time complexity: O(n)
    // Space complexity: O(1)
    // This is a greedy solution that uses the divide and conquer approach to find
    // the maximum subarray sum.
    // It divides the array into two halves, finds the maximum subarray sum in each
    // half,
    // and then finds the maximum subarray sum that crosses the midpoint.
    // The maximum subarray sum is the maximum of these three values.
    // The base case is when the array has only one element, in which case the
    // maximum subarray sum is that element.

    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            maxSum = Math.max(maxSum, currentSum);
            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        return maxSum;
    }

    // Example usage
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(solution.maxSubArray(nums)); // Output: 6
    }

}