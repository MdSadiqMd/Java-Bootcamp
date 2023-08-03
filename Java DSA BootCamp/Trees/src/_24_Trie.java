/*
A trie (pronounced as "try" or "tree") is a tree-like data structure used to efficiently store and retrieve strings or sequences of characters. Each node in the trie represents a single character, and the
paths from the root to the leaf nodes form the strings stored in the trie. Trie is also known as a prefix tree, as common prefixes among different strings are shared in the tree structure.

Necessity of Trie:
The trie data structure is particularly useful in scenarios where we need to:
1. Efficiently store and retrieve strings: Trie allows for efficient insertion, deletion, and search operations for strings, making it suitable for tasks like dictionary implementations, autocomplete systems, and spell checkers.
2. Efficiently search for strings with a common prefix: Trie enables us to efficiently find all strings that share a common prefix, which is beneficial for applications like autocomplete or auto-suggestions.
3. Implement word-based applications: Tries are commonly used in word games, word search puzzles, and other applications that involve a large number of words.

Insertion in Trie (with Example):
Let's demonstrate the insertion of the words "car," "cat," "cab," "can," and "care" into a trie:
1. Start with an empty trie:

```
   (Root)
    / | | \
   c  a r  n
```
2. Insert "car":

```
   (Root)
    / | | \
   c  a r  n
       |
       a
       |
       r
```

3. Insert "cat":

```
   (Root)
    / | | \
   c  a r  n
    \   |
     t  a
         |
         r
```
4. Insert "cab":

```
   (Root)
    / | | \
   c  a r  n
    \  |  |
     t a  b
         |
         r
```
5. Insert "can":

```
   (Root)
    / | | \
   c  a r  n
    \ /|  |
     t a  b
      |   |
      n   r
```
6. Insert "care":

```
   (Root)
    / | | \
   c  a r  n
    \ /| | \
     t a b e
      |   |
      n   r
```
As you can see, each character in a word is represented by a node in the trie, and paths from the root to the leaf nodes represent the inserted words. Trie's structure efficiently stores strings, allows quick prefix-based searches, and reduces memory consumption for a large number of words with shared prefixes.
 */
public class _24_Trie {
    static class Node {
        Node[] children;
        boolean endOfWord;

        public Node() {
            children = new Node[26]; // a to z
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            endOfWord = false;
        }
    }

    static Node root;

    _24_Trie() {
        root = new Node();
    }

    // Creating Trie with Inserting the Nodes
    public void insert(String words) {
        Node root1 = root; // Use a separate variable to traverse the Trie.

        for (int i = 0; i < words.length(); i++) {
            int index = words.charAt(i) - 'a'; // This returns the location index in the Node Array, in java b-a=1,d-a=3,...

            if (root1.children[index] == null) { // Check for null using '=='
                root1.children[index] = new Node();
            }

            if (i == words.length() - 1) {
                root1.children[index].endOfWord = true;
            }

            root1 = root1.children[index]; // Move to the next node in the trie.
        }
    }

    //Searching in Trie
    private static boolean search(String key){
        Node root1 = root; // Use a separate variable to traverse the Trie.
        for(int i=0;i<key.length();i++){
            int index=key.charAt(i) - 'a';
            Node node=root1.children[index];
             if(node==null){
                 return false;
             }
             if(i==key.length()-1 && node.endOfWord ==false){
                 return false;
             }
             root1=root1.children[index];
        }
        return true;
    }

    public static void main(String[] args) {
        _24_Trie trie = new _24_Trie();
        String words[] = { "the", "a", "there", "their", "any" };

        for (String word : words) {
            trie.insert(word);
        }

        System.out.println(search("there"));
        System.out.println(search("sadiq"));
    }
}
