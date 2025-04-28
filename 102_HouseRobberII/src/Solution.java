class Solution {
    // Solution class to implement the House Robber problem II circular array
    // Dynamic Programming approach
    public int rob(int[] nums) {
        // Base cases
        int prev = 0, max1 = 0, max2 = 0;
        // First case: rob from 0 to n-2 (excluding last house)
        for (int i = 0; i < nums.length - 1; i++) {
            int temp = max1; // Store the previous max value
            max1 = Math.max(max1, prev + nums[i]); // Calculate the new max value
            prev = temp; // Update prev to the previous max value
        }
        // Second case: rob from 1 to n-1 (excluding first house)
        prev = 0; // Reset prev for the second case
        for (int i = 1; i < nums.length; i++) {
            int temp = max2; // Store the previous max value
            max2 = Math.max(max2, prev + nums[i]); // Calculate the new max value
            prev = temp; // Update prev to the previous max value
        }
        // Return the maximum of both cases or the single house case
        return nums.length == 1 ? nums[0] : Math.max(max1, max2);
    }

    // Main method to test the solution
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 2, 3, 2 }; // Example input
        System.out.println(solution.rob(nums)); // Expected output: 3
    }
}
