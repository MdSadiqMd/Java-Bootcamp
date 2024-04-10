import java.util.Stack;

public class Sorting_Stack {
    public static void sort(Stack<Integer> stack){
        Stack<Integer> temp=new Stack<>();
        while(!stack.isEmpty()){
            int current=stack.pop();
            while(!temp.isEmpty()&&temp.peek()>current) stack.push(temp.pop());
            temp.push(current);
        }
        while(!temp.isEmpty()) stack.push(temp.pop());
    }
    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();
        stack.push(5);stack.push(3);stack.push(4);stack.push(1);stack.push(2);
        sort(stack);
        System.out.println(stack);
    }
}
