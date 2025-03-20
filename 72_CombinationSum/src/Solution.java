import java.util.*;

class Solution {
    // Function to find all unique combinations in the candidates list that sum up to the target
    // The same number can be chosen from the candidates list multiple times
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();

        backtrack(target, res, combination, 0, candidates);
        return res;
    }

    // Helper function to backtrack and find the combinations
    private void backtrack(int target, List<List<Integer>> res, List<Integer> combination, int start, int[] candidates) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            res.add(new ArrayList<>(combination));
        } else {
            for (int i = start; i < candidates.length; i++) {
                combination.add(candidates[i]);
                backtrack(target - candidates[i], res, combination, i, candidates);
                combination.remove(combination.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> result = solution.combinationSum(candidates, target);
        System.out.println(result);

        // Test case 2
        candidates = new int[]{2, 3, 5};
        target = 8;
        result = solution.combinationSum(candidates, target);
        System.out.println(result);
    }
}