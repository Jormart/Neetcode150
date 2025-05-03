class Solution {
    // Dynamic programming approach to solve the partition problem
    // Time complexity: O(n * sum(nums))
    // Space complexity: O(sum(nums))
    // where n is the number of elements in nums and sum(nums) is the total sum of
    // the array.
    // This approach uses a 1D array to keep track of the possible sums that can be
    // formed from the elements in nums. The idea is to iterate through the array
    // and update the dp array for each element in nums. If the current element can
    // be added to a previously formed sum, we update the dp array accordingly.
    // Finally, we check if the target sum can be formed by checking if dp[target]
    // is true. The target sum is half of the total sum of the array. If the total
    // sum is odd, we cannot partition the array into two equal subsets, so we
    // return false.

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // If the total sum is odd, we cannot partition it into two equal subsets
        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // Base case: a sum of 0 can always be formed

        for (int num : nums) {
            // Go backwards to avoid using the same number multiple times
            for (int j = target; j >= num; j--) {
                if (dp[j - num]) {
                    dp[j] = true;
                }
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 1, 5, 11, 5 };
        System.out.println(solution.canPartition(nums)); // Output: true
    }
}