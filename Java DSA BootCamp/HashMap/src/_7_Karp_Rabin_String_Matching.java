// The Karp Rabin Algorithm Compare the hash value of a string with the hash value of the other String in slots leading for string matching
class KarpRabin {
    private final int PRIME = 101;

    private long calculateHash(String str) {
        long hash = 0;
        for (int i = 0; i < str.length(); i++) {
            hash += str.charAt(i) * Math.pow(PRIME, i);
        }
        return hash;
    }

    private long updateHash(long prevHash, char oldChar, char newChar, int patternLength) {
        long newHash = (long) ((prevHash - oldChar * Math.pow(PRIME, 0)) / PRIME);
        newHash = (long) (newHash + newChar * Math.pow(PRIME, patternLength - 1));
        return newHash;
    }

    public void search(String text, String pattern) {
        int patternLength = pattern.length();
        long patternHash = calculateHash(pattern);
        long textHash = calculateHash(text.substring(0, patternLength));

        for (int i = 0; i <= text.length() - patternLength; i++) {
            if (textHash == patternHash) {
                if (text.substring(i, i + patternLength).equals(pattern)) {
                    System.out.println("Pattern found at index " + i);
                }
            }
            if (i < text.length() - patternLength) {
                textHash = updateHash(textHash, text.charAt(i), text.charAt(i + patternLength), patternLength);
            }
        }
    }
}

public class _7_Karp_Rabin_String_Matching {
    public static void main(String[] args) {
        KarpRabin algo = new KarpRabin();
        algo.search("MohammadSadiq", "Sadiq");
    }
}

