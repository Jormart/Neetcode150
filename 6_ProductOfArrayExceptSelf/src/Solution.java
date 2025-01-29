import java.util.*;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        // Create an array to store the product of all elements to the left of the
        // current element
        int[] result = new int[nums.length];
        Arrays.fill(result, 1); // Initialize all elements to 1
        int pre = 1, post = 1; // Initialize pre and post to 1
        // Calculate the product of all elements to the left of the current element
        for (int i = 0; i < nums.length; i++) {
            result[i] = pre;
            pre *= nums[i];
        }
        // Calculate the product of all elements to the right of the current element
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= post;
            post *= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = { 1, 2, 3, 4 };
        int[] result = sol.productExceptSelf(nums);
        System.out.println(Arrays.toString(result));
    }
}
