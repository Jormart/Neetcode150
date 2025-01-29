class Solution {
    public int maxArea(int[] height) {
        // Two pointer approach to solve this problem
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        // Loop until left and right pointers meet
        while (left < right) {
            int currentArea = Math.min(height[left], height[right]) * (right - left);
            // Update maxArea if currentArea is greater
            maxArea = Math.max(maxArea, currentArea);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        // Output: 49
        System.out.println(solution.maxArea(height));
    }
}