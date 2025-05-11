// 45. Jump Game II
// https://leetcode.com/problems/jump-game-ii/description/
class Solution {
    // Greedy approach
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // The idea is to keep track of the farthest point we can reach at each step
    // and when we reach the end of the current jump, we increment the jump count
    // and update the current end to the farthest point we can reach.
    // We do this until we reach the last index.
    // We can also use a greedy approach to find the minimum number of jumps
    // to reach the last index. We keep track of the farthest point we can reach
    // at each step and when we reach the end of the current jump, we increment
    // the jump count and update the current end to the farthest point we can reach.
    // We do this until we reach the last index.
    public int jump(int[] nums) {
        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
        }

        return jumps;
    }

    // Example usage
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 2, 3, 1, 1, 4 };
        System.out.println(solution.jump(nums)); // Output: 2
    }
}