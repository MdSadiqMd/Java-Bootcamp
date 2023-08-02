public class _25_Trie_Maximum_XOR {

    static class TrieNode {
        TrieNode[] children;
        TrieNode() {
            children = new TrieNode[2];
        }
    }

    static TrieNode root;

    static void insert(int num) {
        TrieNode node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.children[bit] == null) {
                node.children[bit] = new TrieNode();
            }
            node = node.children[bit];
        }
    }

    static int findMaxXOR(int num) {
        TrieNode node = root;
        int maxXOR = 0;

        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            int flipBit = 1 - bit;

            if (node.children[flipBit] != null) {
                maxXOR |= (1 << i);
                node = node.children[flipBit];
            } else {
                node = node.children[bit];
            }
        }

        return maxXOR;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 10, 5, 25, 2, 8 };
        int n = arr.length;

        root = new TrieNode();

        int maxXOR = 0;
        for (int num : arr) {
            insert(num);
            maxXOR = Math.max(maxXOR, findMaxXOR(num));
        }

        System.out.println("Maximum XOR value: " + maxXOR);
    }
}
