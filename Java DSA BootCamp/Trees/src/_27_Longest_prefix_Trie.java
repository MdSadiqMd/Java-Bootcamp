// Approach : The Longest node where the endOfWord is True many times is the Answer
public class _27_Longest_prefix_Trie {
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

    _27_Longest_prefix_Trie() {
        root = new Node(); // Initialize the root node here.
    }

    public static void insert(String word) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (current.children[index] == null) {
                current.children[index] = new Node();
            }
            if (i == word.length() - 1) {
                current.children[index].endOfWord = true;
            }
            current = current.children[index];
        }
    }

    public static String ans = "";

    public static void longestPrefix(Node root, StringBuilder temp) {
        if (root == null) {
            return;
        }
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null && root.children[i].endOfWord == true) {
                temp.append((char) (i + 'a'));
                if (temp.length() > ans.length()) {
                    ans = temp.toString();
                }
                longestPrefix(root.children[i], temp);
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        _27_Longest_prefix_Trie trie = new _27_Longest_prefix_Trie(); // Create an instance of the Trie
        String words[] = { "a", "banana", "app", "appl", "ap", "apply", "apple" };
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        longestPrefix(root, new StringBuilder(""));
        System.out.println(ans);
    }
}


