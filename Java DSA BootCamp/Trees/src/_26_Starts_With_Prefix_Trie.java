public class _26_Starts_With_Prefix_Trie {
    static class Node {
        Node[] children;
        boolean endOfWord;

        public Node() {
            children = new Node[26];
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            endOfWord = false;
        }
    }

    static Node root;

    _26_Starts_With_Prefix_Trie() {
        root = new Node(); // Initialize the root node when creating the Trie.
    }

    public static void insert(String words) {
        Node current = root; // Use a separate variable to traverse the Trie.

        for (int i = 0; i < words.length(); i++) {
            int index = words.charAt(i) - 'a';
            if (current.children[index] == null) {
                current.children[index] = new Node();
            }
            if (i == words.length() - 1) {
                current.children[index].endOfWord = true;
            }
            current = current.children[index];
        }
    }

    public static boolean search(String key) {
        Node current = root; // Use a separate variable to traverse the Trie.

        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            Node node = current.children[index];
            if (node == null) {
                return false;
            }
            if (i == key.length() - 1 && !node.endOfWord) {
                return false;
            }
            current = current.children[index];
        }
        return true;
    }

    public static boolean startsWith(String prefix) {
        Node current = root; // Use a separate variable to traverse the Trie.

        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            Node node = current.children[index];
            if (node == null) {
                return false;
            }
            current = current.children[index];
        }
        return true;
    }

    public static void main(String[] args) {
        _26_Starts_With_Prefix_Trie trie = new _26_Starts_With_Prefix_Trie(); // Create the Trie instance.
        String words[] = { "i", "like", "sam", "samsung", "mobile", "ice" };
        String prefix = "sam";

        for (String word : words) {
            insert(word);
        }

        System.out.println(startsWith(prefix)); // Output: true as there are two words starting with the prefix sam and samsung
    }
}
