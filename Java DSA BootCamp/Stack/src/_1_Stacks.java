import java.util.Stack;

public class _1_Stacks {
    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();
        stack.push(3);
        stack.push(2);
        stack.push(6);
        stack.push(4);
        stack.push(9);
        System.out.println(stack.peek()); //This displays the Top-Most Element
        stack.pop(); //This Deletes the Top-Most Element
        System.out.println(stack.peek());
        System.out.println(stack.search(6)); //This Searches the Element in the Stack
        System.out.println(stack.search(5)); //This Returns -1 as the Element is not Present in the Stack
        System.out.println(stack.isEmpty()); //This Returns a Boolean Value do the Stack Contains Elements or not
    }
}
