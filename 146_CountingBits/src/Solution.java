// 338. Counting Bits
// https://leetcode.com/problems/counting-bits/description/
class Solution {
    // Approach using bit manipulation
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // The number of bits in the binary representation of n is equal to the number
    // of bits in n/2 plus 1 if n is odd
    // or 0 if n is even.
    // This is because the binary representation of n can be obtained by right
    // shifting the binary representation of n/2 and adding 1 if n is odd.

    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            // '>>' is the right shift operator, which divides the number by 2
            // 'i & 1' checks if the number is odd (1) or even (0)
            dp[i] = dp[i >> 1] + (i & 1);
        }
        return dp;
    }

    // Example usage
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 5;
        int[] result = solution.countBits(n);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

}