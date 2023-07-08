import java.util.Stack;

public class _2_Queue_Using_Stack {
    public static class QueueUsingStack {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        public void enQueue(int data) {
            stack1.push(data);
        }

        public int deQueue() {
            int ele;
            if (stack1.empty() && stack2.empty()) {
                System.out.println("Queue is Empty");
                System.exit(0);
            }
            if (stack2.empty()) {
                while (!stack1.empty()) {
                    ele = stack1.pop();
                    stack2.push(ele);
                }
            }
            ele = stack2.pop();
            return ele;
        }

        @Override
        public String toString() {
            return "QueueUsingStack{" +
                    "stack1=" + stack1 +
                    ", stack2=" + stack2 +
                    '}';
        }
    }

    public static void main(String[] args) {
        QueueUsingStack q = new QueueUsingStack();
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);
        q.enQueue(4);
        q.enQueue(5);
        System.out.println(q);
        q.deQueue();
        System.out.println(q);
    }
}
