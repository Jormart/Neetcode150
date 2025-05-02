// 152. Maximum Product Subarray
// https://leetcode.com/problems/maximum-product-subarray/
class Solution {
    // Approach: Dynamic Programming using 2 pointers to keep track of the maximum
    // and minimum products
    // We need to keep track of the minimum product as well because a negative
    // number can turn a small negative product into a large positive product when
    // multiplied by another negative number.
    // Time Complexity: O(n) where n is the length of the input array
    // Space Complexity: O(1) since we are using only a constant amount of space
    // to store the maximum and minimum products.

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0; // Handle edge case for empty array
        }

        int maxProduct = nums[0];
        int minProduct = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                // Swap max and min when a negative number is encountered
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }
            maxProduct = Math.max(nums[i], maxProduct * nums[i]);
            minProduct = Math.min(nums[i], minProduct * nums[i]);
            result = Math.max(result, maxProduct);
        }

        return result;
    }

    // Example usage
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 2, 3, -2, 4 };
        System.out.println(solution.maxProduct(nums)); // Output: 6
    }
}