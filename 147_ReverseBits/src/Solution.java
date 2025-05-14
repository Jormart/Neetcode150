// 190. Reverse Bits
// https://leetcode.com/problems/reverse-bits/
public class Solution {
    // you need treat n as an unsigned value
    // Function to reverse bits of a given 32 bits unsigned integer
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    // Approach: Use bit manipulation to reverse the bits
    public int reverseBits(int n) {
        int reverse = 0;
        for (int i = 0; i < 32; i++) {
            reverse = reverse << 1; // Shift reverse left by 1
            reverse |= (n & 1); // Add the least significant bit of n to reverse
            n = n >> 1; // Shift n right by 1 (unsigned)
        }

        return reverse; // Return the reversed bits
    }

    // Test the function
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 43261596; // Example input
        int result = solution.reverseBits(n);
        System.out.println("Reversed bits: " + result); // Expected output: 964176192
    }
}