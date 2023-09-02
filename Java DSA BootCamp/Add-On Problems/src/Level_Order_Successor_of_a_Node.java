import java.util.LinkedList;
import java.util.Queue;

class Node2 {
    int data;
    Node2 left, right;

    public Node2(int data) {
        this.data = data;
        left = right = null;
    }
}

public class Level_Order_Successor_of_a_Node {
    Node2 root;

    Level_Order_Successor_of_a_Node() {
        root = null;
    }

    public Node2 findSuccessor(Node2 root, int target) {
        if (root == null) {
            return null;
        }

        Queue<Node2> queue = new LinkedList<>();
        queue.add(root);
        boolean foundTarget = false;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            foundTarget = false;

            for (int i = 0; i < levelSize; i++) {
                Node2 current = queue.poll();

                // If the target node was found in the previous level, the current node is its successor.
                if (foundTarget) {
                    return current;
                }

                if (current.data == target) {
                    foundTarget = true; // Mark that we found the target node.
                }

                // Add the children to the queue.
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }

        // If the target node was not found or is the last node in the tree, there's no successor.
        return null;
    }

    public static void main(String[] args) {
        Level_Order_Successor_of_a_Node tree = new Level_Order_Successor_of_a_Node();
        tree.root = new Node2(1);
        tree.root.left = new Node2(2);
        tree.root.right = new Node2(3);
        tree.root.left.left = new Node2(4);
        tree.root.right.left = new Node2(5);
        tree.root.right.right = new Node2(6);
        tree.root.right.left.left = new Node2(7);
        tree.root.right.left.right = new Node2(8);

        int target = 6;
        Node2 successor = tree.findSuccessor(tree.root, target);

        if (successor != null) {
            System.out.println("The level order successor of " + target + " is " + successor.data);
        } else {
            System.out.println(target + " does not have a level order successor.");
        }
    }
}
