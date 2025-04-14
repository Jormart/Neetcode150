import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // Sort the array to handle duplicates and facilitate the backtracking process
        backtrack(result, new ArrayList<>(), candidates, target, 0); // Start backtracking
        return result; // Return the list of unique combinations
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] candidates, int target,
            int start) {
        // Base case: if the target is met, add the current combination to the result
        // and return to explore other combinations
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1])
                continue; // Skip duplicates
            if (target - candidates[i] < 0)
                break; // No need to continue if the candidate exceeds the targeting target
            current.add(candidates[i]); // Add the candidate to the current combination
            backtrack(result, current, candidates, target - candidates[i], i + 1); // Recur with updated parameters
            current.remove(current.size() - 1); // Backtrack to explore other combinations
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };
        int target = 8;
        List<List<Integer>> result = solution.combinationSum2(candidates, target);
        System.out.println(result); // Expected output: [[1, 1, 6], [1, 2, 5], [2, 6], [7]]
    }
}