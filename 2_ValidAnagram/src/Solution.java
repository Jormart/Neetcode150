class Solution {
    public boolean isAnagram(String s, String t) {
        // If the length of the two strings are not equal, then they can't be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        // Create an array to store the count of each character in the string
        int[] count = new int[26]; // Assuming only lowercase English letters

        // Increment the count of each character in 's'
        // and decrement the count of each character in 't'
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        // Check if all counts are zero
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return false;
            }
        }

        return true; // All counts are zero, so 't' is an anagram of 's'
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test cases
        System.out.println(sol.isAnagram("anagram", "nagaram")); // Output: true
        System.out.println(sol.isAnagram("rat", "car")); // Output: false
    }
}