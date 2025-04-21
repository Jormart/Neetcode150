import java.util.*;

class Solution {
    // Function to find the length of the shortest transformation sequence from
    // beginWord to endWord
    // using words from the wordList
    // The transformation can only change one letter at a time and each transformed
    // word must exist in the wordList
    // The function returns the number of words in the transformation sequence
    // including beginWord and endWord
    // If no such transformation sequence exists, return 0
    // This implementation uses a bidirectional BFS approach for efficiency
    // Time complexity: O(N * M * 26) where N is the number of words in wordList and
    // M is the length of each word
    // Space complexity: O(N + M) for the wordSet and the queue
    // where N is the number of words in wordList and M is the length of each word
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Convert wordList to a HashSet for O(1) lookups
        Set<String> wordSet = new HashSet<>(wordList);

        // Quick check: if endWord is not in wordList, no solution exists
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        // Bidirectional BFS: search from both beginWord and endWord
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);

        // Remove both words to avoid revisiting
        wordSet.remove(beginWord);
        wordSet.remove(endWord);

        int length = 1;

        // Use a single char array for transformations to reduce object creation
        char[] charArray = new char[beginWord.length()];

        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            // For efficiency, always expand the smaller set
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            // Next level of words to explore
            Set<String> nextLevel = new HashSet<>();

            // Explore each word in the current level
            for (String word : beginSet) {
                // For each position in the word
                for (int j = 0; j < word.length(); j++) {
                    word.getChars(0, word.length(), charArray, 0); // More efficient than toCharArray()
                    char originalChar = charArray[j];

                    // Try all possible character substitutions
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == originalChar)
                            continue;

                        charArray[j] = c;
                        String transformed = String.valueOf(charArray);

                        // If the other direction has this word, we've found a path
                        if (endSet.contains(transformed)) {
                            return length + 1;
                        }

                        // If it's a valid unvisited word, add to next level
                        if (wordSet.contains(transformed)) {
                            nextLevel.add(transformed);
                            wordSet.remove(transformed); // Mark as visited
                        }
                    }

                    // Restore the original character
                    charArray[j] = originalChar;
                }
            }

            // Move to next level
            beginSet = nextLevel;
            length++;
        }

        return 0; // No transformation sequence found
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        int result = solution.ladderLength(beginWord, endWord, wordList);
        System.out.println(result); // Output: 5
    }
}