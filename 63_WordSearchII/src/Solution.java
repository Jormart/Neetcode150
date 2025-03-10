// Solution implementation using Trie data structure
// Time complexity: O(M(4⋅3^(L−1))), where M is the number of cells in the board 
// and L is the maximum length of words
import java.util.*;

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    String word = null;
    public TrieNode() {}
}

class Solution {
    // Variables to store the board and result
    private char[][] board = null;
    private ArrayList<String> result = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        // Construct the trie data structure
        TrieNode root = new TrieNode();
        // Insert all the words into the trie
        for (String word : words) {
            TrieNode node = root;
            for (char letter : word.toCharArray()) {
                if (node.children.containsKey(letter)) {
                    node = node.children.get(letter);
                } else {
                    TrieNode newNode = new TrieNode();
                    node.children.put(letter, newNode);
                    node = newNode;
                }
            }
            node.word = word;
        }

        // Store the board and its dimensions
        this.board = board;

        // Traverse the board and search for words in the trie
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (root.children.containsKey(board[row][col])) {
                    backtracking(row, col, root);
                }
            }
        }

        return result; 
    }

    // Helper function to perform backtracking
    private void backtracking(int row, int col, TrieNode parent) {
        char letter = board[row][col];
        TrieNode currNode = parent.children.get(letter);

        // Check if the current node has a word
        if (currNode.word != null) {
            result.add(currNode.word);
            currNode.word = null;
        }

        // Mark the current cell as visited
        board[row][col] = '#';

        // Define the directions to move
        int[] rowOffset = {0, 1, 0, -1};
        int[] colOffset = {1, 0, -1, 0};

        // Traverse the neighbors
        for (int i = 0; i < 4; i++) {
            int newRow = row + rowOffset[i];
            int newCol = col + colOffset[i];

            // Check if the new cell is within the bounds
            if (newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[newRow].length) {
                if (currNode.children.containsKey(board[newRow][newCol])) {
                    backtracking(newRow, newCol, currNode);
                }
            }
        }

        // Restore the cell
        board[row][col] = letter;

        // Optimization: incrementally remove the leaf nodes
        if (currNode.children.isEmpty()) {
            parent.children.remove(letter);
        }
    }

    public static void main(String[] args) {
        // Create a new instance of the Solution class
        Solution solution = new Solution();

        // Define the board and words
        char[][] board = {
            {'o','a','a','n'},
            {'e','t','a','e'},
            {'i','h','k','r'},
            {'i','f','l','v'}
        };
        String[] words = {"oath","pea","eat","rain"};

        // Find the words in the board
        List<String> result = solution.findWords(board, words);

        // Output the result
        System.out.println(result);
    }
}