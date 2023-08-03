public class _25_Word_Break_Problem_Trie {
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

    _25_Word_Break_Problem_Trie() {
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
        Node root1 = root; // Use a separate variable to traverse the Trie.

        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            Node node = root1.children[index];
            if (node == null) {
                return false;
            }
            if (i == key.length() - 1 && !node.endOfWord) {
                return false;
            }
            root1 = root1.children[index];
        }
        return true;
    }

    public static boolean isPresent(String key) {
        if (key.length() == 0) {
            return true;
        }
        for (int i = 0; i <= key.length(); i++) { 
            String firstPart = key.substring(0, i);
            String secondPart = key.substring(i);
            if (search(firstPart) && isPresent(secondPart)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String words[] = { "i", "like", "sam", "samsung", "mobile", "ice" };
        String key1 = "ilikesamsung";
        String key2 = "ilikesong";
        _25_Word_Break_Problem_Trie trie = new _25_Word_Break_Problem_Trie(); // Create the Trie instance.
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        System.out.println(isPresent(key1)); // Output: true
        System.out.println(isPresent(key2)); // Output: false
    }
}
