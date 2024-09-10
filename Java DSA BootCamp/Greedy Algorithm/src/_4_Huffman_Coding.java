import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class HuffmanNode implements Comparable<HuffmanNode> {
    char character;
    int frequency;
    HuffmanNode left, right;
    HuffmanNode(char character, int frequency) {
        this.character = character;
        this.frequency = frequency;
    }
    public int compareTo(HuffmanNode node) {
        return this.frequency - node.frequency;
    }
}

public class  _4_Huffman_Coding {
    private static HuffmanNode node;
    private static HuffmanNode buildHuffmanTree(Map<Character, Integer> freqMap) {
        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            pq.add(new HuffmanNode(entry.getKey(), entry.getValue()));
        }

        while (pq.size() > 1) {
            HuffmanNode left = pq.poll();
            HuffmanNode right = pq.poll();
            HuffmanNode sumNode = new HuffmanNode('-', left.frequency + right.frequency);
            sumNode.left = left;
            sumNode.right = right;
            pq.add(sumNode);
        }
        return pq.poll();
    }

    public static void generateHuffmanCodes(HuffmanNode node, String code, Map<Character, String> huffmanCodeMap) {
        _4_Huffman_Coding.node = node;
        if (node == null) return;
        if (node.left == null && node.right == null) huffmanCodeMap.put(node.character, code);
        generateHuffmanCodes(node.left, code + "0", huffmanCodeMap);
        generateHuffmanCodes(node.right, code + "1", huffmanCodeMap);
    }

    public static String encodeString(String input, Map<Character, String> huffmanCodeMap) {
        StringBuilder encodedStr = new StringBuilder();
        for (char c : input.toCharArray()) {
            encodedStr.append(huffmanCodeMap.get(c));
        }
        return encodedStr.toString();
    }

    public static String decodeString(String encodedStr, Map<Character, String> huffmanCodeMap) {
        Map<String, Character> reverseHuffmanCodeMap = new HashMap<>();
        for (Map.Entry<Character, String> entry : huffmanCodeMap.entrySet()) {
            reverseHuffmanCodeMap.put(entry.getValue(), entry.getKey());
        }

        StringBuilder decodedStr = new StringBuilder();
        StringBuilder currentCode = new StringBuilder();
        for (char bit : encodedStr.toCharArray()) {
            currentCode.append(bit);
            if (reverseHuffmanCodeMap.containsKey(currentCode.toString())) {
                decodedStr.append(reverseHuffmanCodeMap.get(currentCode.toString()));
                currentCode.setLength(0);
            }
        }

        return decodedStr.toString();
    }

    public static void main(String[] args) {
        String input = "BCCDACCBDABCCDEAAEDA";

        // Step 1: Count the frequency of each character
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : input.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: Build Huffman Tree
        HuffmanNode root = buildHuffmanTree(freqMap);

        // Step 3: Generate Huffman Codes
        Map<Character, String> huffmanCodeMap = new HashMap<>();
        generateHuffmanCodes(root, "", huffmanCodeMap);

        // Display Huffman Codes
        System.out.println("Huffman Codes for each character:");
        for (Map.Entry<Character, String> entry : huffmanCodeMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Step 4: Encode the string
        String encodedString = encodeString(input, huffmanCodeMap);
        System.out.println("Encoded String: " + encodedString);

        // Step 5: Decode the string
        String decodeString = decodeString(encodedString, huffmanCodeMap);
        System.out.println("Decoded String: "+ decodeString);
    }
}
