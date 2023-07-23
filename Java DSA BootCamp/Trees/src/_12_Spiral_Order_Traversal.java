class Node11 {
    int data;
    Node11 left, right;
    public Node11(int data) {
        this.data = data;
        left = right = null;
    }
}

public class _12_Spiral_Order_Traversal {
    Node11 root;

    _12_Spiral_Order_Traversal() {
        root = null;
    }

    // Function to print all nodes of a given level from left to right
    public static boolean printLevelLeftToRight(Node11 root, int level) {
        if (root == null) {
            return false;
        }

        if (level == 1) {
            System.out.print(root.data + " ");
            return true;
        }

        // process left child before the right child
        boolean left = printLevelLeftToRight(root.left, level - 1);
        boolean right = printLevelLeftToRight(root.right, level - 1);

        return left || right;
    }

    // Function to print all nodes of a given level from right to left
    public static boolean printLevelRightToLeft(Node11 root, int level) {
        if (root == null) {
            return false;
        }

        if (level == 1) {
            System.out.print(root.data + " ");
            return true;
        }

        // process right child before the left child
        boolean right = printLevelRightToLeft(root.right, level - 1);
        boolean left = printLevelRightToLeft(root.left, level - 1);

        return right || left;
    }

    // Function to find the height of the binary tree
    public static int getHeight(Node11 root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Function to print level order traversal of a given binary tree
    public static void spiralOrderTraversal(Node11 root) {
        if (root == null) {
            return;
        }

        // Find the height of the tree
        int height = getHeight(root);

        // Start from level 1 and alternate between left-to-right and right-to-left
        for (int i = 1; i <= height; i++) {
            if (i % 2 == 1) {
                printLevelLeftToRight(root, i);
            } else {
                printLevelRightToLeft(root, i);
            }
        }
    }

    public static void main(String[] args) {
        _12_Spiral_Order_Traversal tree = new _12_Spiral_Order_Traversal();
        tree.root = new Node11(5);
        tree.root.left = new Node11(2);
        tree.root.right = new Node11(8);
        tree.root.left.left = new Node11(1);
        tree.root.left.right = new Node11(3);
        tree.root.right.left = new Node11(7);
        tree.root.right.right = new Node11(9);

        spiralOrderTraversal(tree.root);
    }
}
