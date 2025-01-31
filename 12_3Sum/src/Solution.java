import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Two pointer approach solution
        Arrays.sort(nums); // Sort the array
        List<List<Integer>> result = new ArrayList<>(); // List to store the result

        // Loop through the array and find the sum of two numbers
        for (int i = 0; i < nums.length && nums[i] <= 0; i++){
            if (i == 0 || nums[i] != nums[i-1]){
                twoSum2(nums, i, result);
            }
        }
        return result;
    }
    // Function to find the sum of two numbers using two pointer approach
    void twoSum2(int[] nums, int i, List<List<Integer>> result){
        int left = i + 1;
        int right = nums.length - 1;

        while (left < right){
            int sum = nums[i] + nums[left] + nums[right];
            if (sum < 0){
                left++;
            } else if (sum > 0){
                right--;
            } else {
                result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                left++;
                right--;

                // Skip the duplicates
                while (left < right && nums[left] == nums[left-1]){
                    left++;
                }
            }
        }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = sol.threeSum(nums);
        System.out.println(result);

        int[] nums2 = {-5, 0, -3, 5, 1, -5, 0, 2, 1};
        List<List<Integer>> result2 = sol.threeSum(nums2);
        System.out.println(result2);
    }
}
