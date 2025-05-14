// 191. Number of 1 Bits
// https://leetcode.com/problems/number-of-1-bits/description/
class Solution {
    // Approach 1: Bit Manipulation
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    // Count the number of 1 bits in the binary representation of n
    // by repeatedly performing bitwise AND with n-1.
    // The expression n & (n - 1) clears the least significant 1 bit in n.
    // We repeat this process until n becomes 0, counting the number of iterations.

    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1); // Clear the least significant 1 bit
            count++;
        }
        return count;
    }

    // Example of usage
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 11; // Binary representation: 1011
        int result = solution.hammingWeight(n);
        System.out.println("Number of 1 bits in " + n + ": " + result); // Output: 3
    }
}