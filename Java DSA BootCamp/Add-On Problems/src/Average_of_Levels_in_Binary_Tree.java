import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node right, left;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class Average_of_Levels_in_Binary_Tree {
    Node root;

    Average_of_Levels_in_Binary_Tree() {
        root = null;
    }

    public static void Order(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            double levelSum = 0;

            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();
                levelSum += currentNode.data;

                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }

            double levelAverage = levelSum / levelSize;
            System.out.println("Average of level: " + levelAverage);
        }
    }

    public static void main(String[] args) {
        Average_of_Levels_in_Binary_Tree tree = new Average_of_Levels_in_Binary_Tree();
        tree.root = new Node(5);
        tree.root.left = new Node(2);
        tree.root.right = new Node(8);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);
        tree.root.right.left = new Node(7);
        tree.root.right.right = new Node(9);

        Order(tree.root);
    }
}
