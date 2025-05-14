import java.util.*;

// 136. Single Number
// https://leetcode.com/problems/single-number/description/
class Solution {
    // Approach: Use XOR operation
    // XOR of a number with itself is 0
    // XOR of a number with 0 is the number itself
    // So, if we XOR all the numbers in the array, the result will be the number
    // that appears only once
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // where n is the number of elements in the array

    public int singleNumber(int[] nums) {
        int result = 0;

        for (int num : nums) {
            result ^= num; // XOR operation
        }

        return result;
    }

    // Test the solution
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 4, 1, 2, 1, 2 };
        System.out.println(solution.singleNumber(nums)); // Output: 4
    }
}