import java.util.ArrayList;
import java.util.List;

public class Letter_Combinations_of_a_Phone_Number {
    public static List<String> letterCombinations(String digits) {
        String[] arr = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> ans = new ArrayList<>();

        if (digits.length() == 0) {
            return ans; // Return an empty list for an empty input.
        }

        // Start with an empty string as the first combination.
        ans.add("");

        for (int i = 0; i < digits.length(); i++) {
            int digit = digits.charAt(i) - '2'; // Convert the digit to an array index.

            // Store the current size of the ans list.
            int size = ans.size();

            for (int j = 0; j < size; j++) {
                String current = ans.remove(0); // Remove and process the first combination.
                String letters = arr[digit]; // Get the characters corresponding to the current digit.

                // Loop through each character.
                for (int k = 0; k < letters.length(); k++) {
                    char letter = letters.charAt(k);

                    // Append the current character to the current combination.
                    String newCombination = current + letter;

                    // Add the new combination to the list of combinations.
                    ans.add(newCombination);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String digits = "23";
        List<String> combinations = letterCombinations(digits);

        // Print the combinations.
        for (String combination : combinations) {
            System.out.println(combination);
        }
    }
}
