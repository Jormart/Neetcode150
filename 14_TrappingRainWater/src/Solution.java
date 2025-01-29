class Solution {
    public int trap(int[] height) {
        // Two pointers approach solution
        int left = 0, right = height.length - 1;
        // Initialize the max values
        int leftMax = 0, rightMax = 0;
        // Initialize the total trapped water
        int totalWater = 0;
        // Loop until the two pointers meet
        while (left < right) {
            if (height[left] < height[right]) {
                // Update the left max value
                leftMax = Math.max(leftMax, height[left]);
                // Check if the current height is less than the left max
                if (height[left] < leftMax) {
                    // Calculate the trapped water
                    totalWater += leftMax - height[left];
                }
                // Move the left pointer
                left++;
            } else {
                // Update the right max value
                rightMax = Math.max(rightMax, height[right]);
                // Check if the current height is less than the right max
                if (height[right] < rightMax) {
                    // Calculate the trapped water
                    totalWater += rightMax - height[right];
                }
                // Move the right pointer
                right--;
            }
        }
        // Return the total trapped water
        return totalWater;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // Test cases to validate the solution
        System.out.println(solution.trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 })); // Output is 6
        System.out.println(solution.trap(new int[] { 4, 2, 0, 3, 2, 5 })); // Output is 9
    }
}