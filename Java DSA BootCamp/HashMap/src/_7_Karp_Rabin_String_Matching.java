// The Karp Rabin Algorithm Compare the hash value of a string with the hash value of the other String in slots leading for string matching
public class _7_Karp_Rabin_String_Matching {
    private final int PRIME=101;
    private double caluclateHash(String str){
        long hash=0;
        for(int i=0;i<str.length();i++){
            hash+=hash+str.charAt(i)*Math.pow(PRIME,i);
        }
        return hash;
    }

    private double updateHash(double prevHash, char oldChar, char newChar, int patternLength){
        double newHash=(prevHash-oldChar)/PRIME;
        newHash= (long) (newHash+newChar*Math.pow(PRIME,patternLength-1));
        return newHash;
    }

    public void search(String text,String pattern){
        int patternLength=pattern.length();
        double patternHash=caluclateHash(pattern);
        double textHash=caluclateHash(text.substring(0,patternLength));

        for(int i=0;i<=text.length();i++){
            if(textHash==patternHash){
                if(text.substring(i,i-patternLength).equals(pattern)){
                    System.out.println("Pattern found at index "+i);
                }
            }
            if(i<text.length()-patternLength){
                textHash=updateHash(textHash,text.charAt(i),text.charAt(i+patternLength),patternLength);
            }
        }
    }

    public static void main(String[] args) {

    }
}
