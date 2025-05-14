// 268. Missing Number
// https://leetcode.com/problems/missing-number/description/
class Solution {
    // Approach: XOR
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // The idea is to XOR all the numbers from 0 to n and all the numbers in the
    // array.
    // The result will be the missing number because all the other numbers will
    // cancel each other out.
    // The XOR of a number with itself is 0, and the XOR of a number with 0 is the
    // number itself.
    // So, if we XOR all the numbers from 0 to n with all the numbers in the array,
    // the result will be the missing number.

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int xor = 0;

        // XOR all the numbers from 0 to n
        for (int i = 0; i <= n; i++) {
            xor ^= i;
        }

        // XOR all the numbers in the array
        for (int num : nums) {
            xor ^= num;
        }

        return xor;
    }

    // Example of usage
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 3, 0, 1 };
        System.out.println(solution.missingNumber(nums)); // Output: 2
    }
}