import java.util.Stack;

public class Generate_Parenthesis {
    public static void Generate(int n){
        int[] ans=new int[3];
        Stack<Object> stack=new Stack<>();
        for(int i=0;i<n;i++){
            stack.push("(");
            stack.push(")");
        }

    }
    public static void main(String[] args) {
        int n=3;
        Generate(n);
    }
}
