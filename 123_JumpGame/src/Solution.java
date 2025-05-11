// 56. Jump Game
// https://leetcode.com/problems/jump-game/description/
class Solution {
    // Greedy approach
    // The idea is to keep track of the farthest index we can reach at each step.
    // If at any point the current index exceeds the maximum reachable index, we
    // cannot proceed further.
    // If we can reach or exceed the last index, we return true.
    // Time complexity: O(n), where n is the length of the input array.
    // Space complexity: O(1), as we are using only a constant amount of space.
    // This is a greedy algorithm that iterates through the array from the end to
    // the beginning.
    public boolean canJump(int[] nums) {
        int maxReachable = nums.length - 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= maxReachable) {
                maxReachable = i;
            }
        }

        return maxReachable == 0;
    }

    // Example usage
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 2, 3, 1, 1, 4 };
        System.out.println(solution.canJump(nums)); // Output: true
        int[] nums2 = { 3, 2, 1, 0, 4 };
        System.out.println(solution.canJump(nums2)); // Output: false
    }
}