class Node15 {
    int data;
    Node15 left, right;

    public Node15(int data) {
        this.data = data;
        left = right = null;
    }
}

public class _16_Mirror_Image_of_BST {
    Node15 root;

    _16_Mirror_Image_of_BST() {
        root = null;
    }

    // Method to create a mirror image of a binary tree
    public Node15 mirrorImage(Node15 node) {
        if (node == null) {
            return null;
        }

        // Swap the left and right subtrees
        Node15 temp = node.left;
        node.left = node.right;
        node.right = temp;

        // Recur for left and right subtrees
        node.left = mirrorImage(node.left);
        node.right = mirrorImage(node.right);

        return node;
    }

    // Post-order traversal of the tree
    public void postOrder(Node15 node) {
        if (node == null) {
            return;
        }
        // Recur for the left subtree
        postOrder(node.left);
        // Recur for the right subtree
        postOrder(node.right);
        // Visit the root node
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        _16_Mirror_Image_of_BST tree = new _16_Mirror_Image_of_BST();
        tree.root = new Node15(5);
        tree.root.left = new Node15(2);
        tree.root.right = new Node15(8);
        tree.root.left.left = new Node15(1);
        tree.root.left.right = new Node15(3);
        tree.root.right.left = new Node15(7);
        tree.root.right.right = new Node15(9);

        // Create a mirror image of the tree
        Node15 mirroredRoot = tree.mirrorImage(tree.root);

        System.out.println("Post-order Traversal of the Mirror Image:");
        tree.postOrder(mirroredRoot);
    }
}
