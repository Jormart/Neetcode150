import java.util.*;
// 269. Alien Dictionary
// https://leetcode.com/problems/alien-dictionary/description/

class Solution {
    // 1. Create a graph of the words
    // 2. Create an indegree array to track the number of incoming edges for each
    // character
    // 3. Build the graph and indegree array by comparing adjacent words
    // 4. Use a queue to perform topological sort
    // 5. If we can include all characters in the result, return it; otherwise,
    // return an empty string
    // This algorithm is based on Kahn's algorithm for topological sorting.
    // It uses a queue to process nodes with zero indegree and builds the result
    // Time complexity: O(C) where C is total length of all the words combined
    // Space complexity: O(1) since there are at most 26 characters in the alphabet

    public String foreignDictionary(String[] words) {
        // Edge case: empty input
        if (words == null || words.length == 0)
            return "";

        // Initialize graph and indegree map (at most 26 characters)
        Map<Character, Set<Character>> graph = new HashMap<>();
        int[] indegree = new int[26];
        boolean[] exists = new boolean[26]; // Track which chars actually exist
        int charCount = 0; // Count how many unique characters we have

        // Add all characters to the graph
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (!exists[c - 'a']) {
                    exists[c - 'a'] = true;
                    charCount++;
                }
                graph.putIfAbsent(c, new HashSet<>());
            }
        }

        // Build the graph and indegrees
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];

            // Check for invalid input: if word1 is prefix of word2, they are in order
            // but if word2 is prefix of word1, that's invalid
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }

            // Find first different character and create the edge
            int minLength = Math.min(word1.length(), word2.length());
            for (int j = 0; j < minLength; j++) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);
                if (c1 != c2) {
                    // If this edge doesn't already exist, add it
                    if (!graph.get(c1).contains(c2)) {
                        graph.get(c1).add(c2);
                        indegree[c2 - 'a']++;
                    }
                    break; // Only need first different character
                }
            }
        }

        // Perform topological sort using queue
        Queue<Character> queue = new LinkedList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            if (exists[c - 'a'] && indegree[c - 'a'] == 0) {
                queue.offer(c);
            }
        }
        // If no characters are in the queue, we have a cycle
        StringBuilder result = new StringBuilder();
        while (!queue.isEmpty()) {
            char c = queue.poll();
            result.append(c);

            // Process neighbors
            if (graph.containsKey(c)) {
                for (char neighbor : graph.get(c)) {
                    indegree[neighbor - 'a']--;
                    if (indegree[neighbor - 'a'] == 0) {
                        queue.offer(neighbor);
                    }
                }
            }
        }

        // Check for cycle - if we couldn't include all characters
        return result.length() == charCount ? result.toString() : "";
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words = { "wrt", "wrf", "er", "ett", "rftt" };
        System.out.println(solution.foreignDictionary(words)); // Output: "wertf"
    }
}
