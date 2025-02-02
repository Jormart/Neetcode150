class Solution {
    public int characterReplacement(String s, int k) {
        // Create a frequency array to store the frequency of each character
        int[] freq = new int[26];
        // Initialize the left and right pointers
        int left = 0, right = 0;
        // Initialize the maximum frequency of a character in the window
        int maxFreq = 0;
        // Initialize the answer
        int ans = 0;
        // Iterate the right pointer
        for (right = 0; right < s.length(); right++) {
            // Update the maximum frequency of a character in the window
            maxFreq = Math.max(maxFreq, ++freq[s.charAt(right) - 'A']);
            // If the window size minus the maximum frequency is greater than k
            // we need to shrink the window
            if (right - left + 1 - maxFreq > k) {
                // Update the frequency of the character at the left pointer
                freq[s.charAt(left) - 'A']--;
                // Move the left pointer
                left++;
            }
            // Update the answer
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        // Test case 1
        String s1 = "ABAB";
        int k1 = 2;
        // Output: 4
        System.out.println(sol.characterReplacement(s1, k1));
        // Test case 2
        String s2 = "AABABBA";
        int k2 = 1;
        // Output: 4
        System.out.println(sol.characterReplacement(s2, k2));
    }
}