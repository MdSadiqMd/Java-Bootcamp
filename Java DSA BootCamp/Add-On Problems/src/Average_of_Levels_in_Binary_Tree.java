import java.util.LinkedList;
import java.util.Queue;

class Node1 {
    int data;
    Node1 right, left;

    public Node1(int data) {
        this.data = data;
        left = right = null;
    }
}

public class Average_of_Levels_in_Binary_Tree {
    Node1 root;

    Average_of_Levels_in_Binary_Tree() {
        root = null;
    }

    public static void Order(Node1 root) {
        if (root == null) {
            return;
        }

        Queue<Node1> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            double levelSum = 0;

            for (int i = 0; i < levelSize; i++) {
                Node1 currentNode = queue.poll();
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
        tree.root = new Node1(5);
        tree.root.left = new Node1(2);
        tree.root.right = new Node1(8);
        tree.root.left.left = new Node1(1);
        tree.root.left.right = new Node1(3);
        tree.root.right.left = new Node1(7);
        tree.root.right.right = new Node1(9);

        Order(tree.root);
    }
}
