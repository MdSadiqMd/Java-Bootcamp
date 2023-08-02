public class _24_Trie {
    public class TrieNode {
        boolean isEndOfWord;
        TrieNode[] children;

        public TrieNode() {
            isEndOfWord = false;
            children = new TrieNode[26]; // Assuming lowercase English letters
        }
    }

    private TrieNode root;

    public _24_Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return node.isEndOfWord;
    }

    public static void main(String[] args) {
        _24_Trie trie = new _24_Trie();

        // Insert words into the Trie
        trie.insert("apple");
        trie.insert("app");
        trie.insert("banana");

        // Search for words in the Trie
        System.out.println(trie.search("apple"));   // Output: true
        System.out.println(trie.search("app"));     // Output: true
        System.out.println(trie.search("banana"));  // Output: true
        System.out.println(trie.search("orange"));  // Output: false
    }
}
