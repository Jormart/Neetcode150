import java.util.*;

// Time Complexity: O(2^n)
// Space Complexity: O(n)
// Note: The number of subsets of a set with n elements is 2^n.
class Solution {
    // Solution 1: Backtracking + Recursion
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), nums, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> subset, int[] nums, int start) {
        res.add(new ArrayList<>(subset));
        for (int i = start; i < nums.length; i++) {
            subset.add(nums[i]);
            backtrack(res, subset, nums, i + 1);
            subset.remove(subset.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = s.subsets(nums);
        System.out.println(res);
    }
    
}