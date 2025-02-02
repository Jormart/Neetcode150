class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // If s1 is longer than s2, return false
        if (s1.length() > s2.length()) {
            return false;
        }
        // Initialize two arrays to store the frequency of each character in s1 and s2
        int[] s1Freq = new int[26];
        int[] s2Freq = new int[26];
        // Initialize the frequency of each character in s1 and s2
        for (int i = 0; i < s1.length(); i++) {
            s1Freq[s1.charAt(i) - 'a']++;
            s2Freq[s2.charAt(i) - 'a']++;
        }
        // Slide the window through s2 and compare the maps
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (isSame(s1Freq, s2Freq)) {
                return true;
            }
            // Move the window to the right
            s2Freq[s2.charAt(i + s1.length()) - 'a']++; // Add the new character to the window
            s2Freq[s2.charAt(i) - 'a']--; // Remove the old character from the window
        }
        // Check the last window
        return isSame(s1Freq, s2Freq);
    }

    // Helper function to check if two maps are the same
    private boolean isSame(int[] s1Freq, int[] s2Freq) {
        for (int i = 0; i < 26; i++) {
            if (s1Freq[i] != s2Freq[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println("Test case 1: " + sol.checkInclusion(s1, s2));
        s1 = "ab";
        s2 = "eidboaoo";
        System.out.println("Test case 2: " + sol.checkInclusion(s1, s2));
    }

}