import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node6 {
    int data;
    Node6 left, right;

    public Node6(int data) {
        this.data = data;
        left = right = null;
    }
}

public class _7_Level_Order_Traversal {
    Node6 root;

    _7_Level_Order_Traversal() {
        root = null;
    }

    public List<List<Integer>> levelOrder(Node6 root) {
        List<List<Integer>> levels = new ArrayList<>();
        if (root == null) {
            return levels;
        }

        Queue<Node6> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                Node6 node = queue.remove();
                currentLevel.add(node.data);

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            levels.add(currentLevel);
        }
        return levels;
    }

    public static void main(String[] args) {
        _7_Level_Order_Traversal tree = new _7_Level_Order_Traversal();
        tree.root = new Node6(1);
        tree.root.left = new Node6(2);
        tree.root.right = new Node6(3);
        tree.root.left.left = new Node6(4);
        tree.root.right.left = new Node6(5);
        tree.root.right.right = new Node6(6);
        tree.root.right.left.left = new Node6(7);
        tree.root.right.left.right = new Node6(8);

        List<List<Integer>> result = tree.levelOrder(tree.root);
        System.out.println(result);
    }
}
