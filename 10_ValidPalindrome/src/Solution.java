class Solution {
    public boolean isPalindrome(String s) {
        // Initialize left and right pointers
        int left = 0, right = s.length() - 1;
        // Loop until left pointer is less than right pointer
        while (left < right) {
            // Check if left character is not alphanumeric
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            // Check if right character is not alphanumeric
            else if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            // Check if left and right characters are not equal
            else if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            // Move left pointer to right
            else {
                left++;
                right--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // Test cases to validate the solution
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama")); // Expected true
    }
}