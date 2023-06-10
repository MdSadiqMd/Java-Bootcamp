import java.util.Scanner;
import java.util.Stack;

public class Balance_Parenthesis {
    public static Boolean BalanceParenthesis(String Input) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < Input.length(); i++) {
            char ch = Input.charAt(i);
            if (ch == '[' || ch == '{' || ch == '(') {
                stack.push(ch);
            } else if (ch == ']' || ch == '}' || ch == ')') {
                if (stack.isEmpty())
                    return false;

                char top = stack.pop();
                if ((ch == ']' && top != '[') || (ch == '}' && top != '{') || (ch == ')' && top != '('))
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter parentheses: ");
        String Input = sc.nextLine();

        if (BalanceParenthesis(Input)) {
            System.out.println("Balanced");
        } else {
            System.out.println("Not Balanced");
        }
    }
}
