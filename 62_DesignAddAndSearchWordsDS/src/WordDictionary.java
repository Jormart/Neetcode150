class WordDictionary {
    // Define the TrieNode class
    private class TrieNode {
        private TrieNode[] links;
        private final int R = 26;
        private boolean isEnd;

        public TrieNode() {
            links = new TrieNode[R];
        }

        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        public void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }

    /** Initialize your data structure here. */
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd();
    }

    public boolean search(String word) {
        return match(word, 0, root);
    }

    private boolean match(String word, int index, TrieNode node) {
        if (index == word.length()) {
            return node.isEnd();
        }
        char currentChar = word.charAt(index);
        if (currentChar == '.') {
            for (int i = 0; i < 26; i++) {
                char ch = (char) ('a' + i);
                if (node.containsKey(ch) && match(word, index + 1, node.get(ch))) {
                    return true;
                }
            }
        } else {
            return node.containsKey(currentChar) && match(word, index + 1, node.get(currentChar));
        }
        return false;
    }

    public static void main(String[] args) {
        WordDictionary obj = new WordDictionary();
        obj.addWord("bad");
        obj.addWord("dad");
        obj.addWord("mad");
        System.out.println(obj.search("pad")); // false
        System.out.println(obj.search("bad")); // true
        System.out.println(obj.search(".ad")); // true
        System.out.println(obj.search("b..")); // true
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */