class Solution {
    public int rob(int[] nums) {
        // Base cases
        int prev = 0; // Previous max amount robbed
        int max = 0; // Current max amount robbed
        for (int num : nums) {
            int temp = max; // Store current amount before updating
            max = Math.max(prev + num, max); // Update current max amount robbed
            prev = temp; // Update previous max amount robbed
        }
        return max; // Return the maximum amount robbed
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 2, 7, 9, 3, 1 };
        System.out.println(solution.rob(nums)); // Output: 12
    }

}