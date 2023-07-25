/*
--> AVL - Adelson Velskii and Lamdis
--> It is a Self - Balancing BST which balances when the Balance of the tree changes when Node is Added to the Tree
--> In BST when the tree is long One-Direction Tree then the Time Complexity for searching an Element in Tree will be O(n) from O(log n)
--> *** If (Height of left Sub - Tree) - (Height of Right Sub - Tree) = 0 (or) 1 it's a Balanced Tree
 */
class Node22 {
    int data;
    Node22 left, right;
    int height; // Height of the node (you need to maintain this to calculate the balance factor)
    public Node22(int data) {
        this.data = data;
        left = right = null;
        height = 1;
    }
}

public class _23_AVL_Trees {
    Node22 root;
    _23_AVL_Trees() {
        root = null;
    }
    // Calculate the height of a node
    private int height(Node22 node) {
        if (node == null)
            return 0;
        return node.height;
    }
    // Calculate the balance factor of a node
    private int balanceFactor(Node22 node) {
        if (node == null)
            return 0;
        return height(node.left) - height(node.right);
    }

    // Perform left rotation
    private Node22 leftRotate(Node22 z) {
        Node22 y = z.right;
        Node22 T2 = y.left;

        y.left = z;
        z.right = T2;

        // Update heights
        z.height = Math.max(height(z.left), height(z.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    // Perform right rotation
    private Node22 rightRotate(Node22 y) {
        Node22 x = y.left;
        Node22 T2 = x.right;

        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    // Insert a node into the AVL Tree
    private Node22 insert(Node22 node, int value) {
        if (node == null)
            return new Node22(value);

        if (value < node.data)
            node.left = insert(node.left, value);
        else if (value > node.data)
            node.right = insert(node.right, value);
        else // Duplicate values are not allowed
            return node;

        // Update the height of the current node
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Get the balance factor of the current node
        int balance = balanceFactor(node);

        // Perform necessary rotations to balance the tree
        // Left Left Case
        if (balance > 1 && value < node.left.data)
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && value > node.right.data)
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && value > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && value < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        // Return the unchanged node if no rotations are required
        return node;
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    // Inorder traversal to display the AVL Tree
    private void inorderTraversal(Node22 node) {
        if (node == null)
            return;

        inorderTraversal(node.left);
        System.out.print(node.data + " ");
        inorderTraversal(node.right);
    }

    public void inorderTraversal() {
        inorderTraversal(root);
    }

    public static void main(String[] args) {
        _23_AVL_Trees tree = new _23_AVL_Trees();
        tree.insert(5);
        tree.insert(2);
        tree.insert(8);
        tree.insert(1);
        tree.insert(3);
        tree.insert(7);
        tree.insert(9);
        tree.inorderTraversal(); // Output: 1 2 3 5 7 8 9
    }
}

