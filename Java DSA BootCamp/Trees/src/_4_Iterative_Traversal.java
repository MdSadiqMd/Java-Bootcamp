import java.util.Stack;

class Node3 {
    int data;
    Node3 left, right;
    public Node3(int data) {
        this.data = data;
        left = right = null;
    }
}

public class _4_Iterative_Traversal {
    Node3 root;

    _4_Iterative_Traversal() {
        root = null;
    }

    public void InorderTraversal(Node3 node) {
        Stack<Node3> stack = new Stack<>();

        while (node != null || !stack.isEmpty()) {
            // Traverse the left subtree and push nodes onto the stack
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            // Pop the top node from the stack and print its data
            Node3 current = stack.pop();
            System.out.print(current.data + " ");

            // Move to the right subtree
            node = current.right;
        }
    }

    public void preOrderTraversal(Node3 node) {
        if (node == null) {
            return;
        }

        Stack<Node3> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            Node3 current = stack.pop();
            System.out.print(current.data + " ");

            // Push the right child first, so it gets processed after the left child
            if (current.right != null) {
                stack.push(current.right);
            }

            // Push the left child second, so it gets processed first
            if (current.left != null) {
                stack.push(current.left);
            }
        }
    }

    public void postOrderTraversal(Node3 node) {
        if (node == null) {
            return;
        }

        Stack<Node3> stack = new Stack<>();
        stack.push(node);

        // Another stack to reverse the output order
        Stack<Integer> outputStack = new Stack<>();

        while (!stack.isEmpty()) {
            Node3 current = stack.pop();
            outputStack.push(current.data);

            // Push the left child first, so it gets processed after the right child
            if (current.left != null) {
                stack.push(current.left);
            }

            // Push the right child second, so it gets processed first
            if (current.right != null) {
                stack.push(current.right);
            }
        }

        // Print the nodes in reverse order to get post-order traversal
        while (!outputStack.isEmpty()) {
            System.out.print(outputStack.pop() + " ");
        }
    }

    public static void main(String[] args) {
        _4_Iterative_Traversal tree = new _4_Iterative_Traversal();
        tree.root = new Node3(1);
        tree.root.left = new Node3(2);
        tree.root.right = new Node3(3);
        tree.root.left.left = new Node3(4);
        tree.root.right.left = new Node3(5);
        tree.root.right.right = new Node3(6);
        tree.root.right.left.left = new Node3(7);
        tree.root.right.left.right = new Node3(8);

        System.out.println("In-Order Traversal (Iterative):");
        tree.InorderTraversal(tree.root);

        System.out.println("\nPre-Order Traversal (Iterative):");
        tree.preOrderTraversal(tree.root);

        System.out.println("\nPost-Order Traversal (Iterative):");
        tree.postOrderTraversal(tree.root);
    }
}
