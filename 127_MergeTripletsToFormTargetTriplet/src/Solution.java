// 1899. Merge Triplets to Form Target Triplet
// https://leetcode.com/problems/merge-triplets-to-form-target-triplet/
class Solution {
    // Greedy solution to check if we can form the target triplet
    // by merging triplets
    // Time complexity: O(n)
    // Space complexity: O(1)
    // where n is the number of triplets
    // The idea is to check if we can form the target triplet
    // by merging the triplets
    // We can merge triplets if the maximum value of each index
    // of the triplet is equal to the target value
    // We can merge triplets if the maximum value of each index
    // of the triplet is less than or equal to the target value

    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean[] valid = new boolean[3];
        // Check if the triplet is valid
        for (int[] triplet : triplets) {
            if (triplet[0] > target[0] || triplet[1] > target[1] || triplet[2] > target[2]) {
                continue;
            }
            for (int i = 2; i >= 0; i--) {
                if (triplet[i] == target[i]) {
                    valid[i] = true;
                }
            }
        }
        // Check if all target values are present in the valid triplets
        return valid[0] && valid[1] && valid[2];
    }

    // Example of usage
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] triplets = { { 1, 3, 2 }, { 2, 2, 3 }, { 3, 1, 1 } };
        int[] target = { 2, 3, 1 };
        boolean result = solution.mergeTriplets(triplets, target);
        System.out.println(result); // Output: false
    }
}