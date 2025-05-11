import java.util.*;

// 763. Partition Labels
// https://leetcode.com/problems/partition-labels/
class Solution {
    // Greedy approach to partition labels
    // 1. Find the last occurrence of each character in the string.
    // 2. Iterate through the string and keep track of the last occurrence of the
    // current character.
    // 3. If the current index is equal to the last occurrence of the current
    // character, we can partition the string.
    // 4. Add the length of the current partition to the result list.
    // 5. Return the result list.
    // Time complexity: O(n), where n is the length of the string.
    // Space complexity: O(1), since we are using a fixed-size array to store the
    // last occurrence of each character.
    public List<Integer> partitionLabels(String s) {

        // Step 1: Find the last occurrence of each character
        int[] lastOccurrence = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastOccurrence[s.charAt(i) - 'a'] = i;
        }
        // Step 2: Iterate through the string and partition
        List<Integer> result = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, lastOccurrence[s.charAt(i) - 'a']);
            // When we reach the end of a partition
            if (i == end) {
                result.add(end - start + 1);
                start = end + 1; // Move to the next partition
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "ababcbacadefegdehijhklij";
        List<Integer> result = solution.partitionLabels(s);
        System.out.println(result); // Output: [9, 7, 8]
    }
}