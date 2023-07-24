class Node17 {
    int data;
    Node17 left, right;

    public Node17(int data) {
        this.data = data;
        left = right = null;
    }
}

public class _18_Deleting_Element_in_BST {
    Node17 root;

    _18_Deleting_Element_in_BST() {
        root = null;
    }

    public Node17 findNode(Node17 root, int dNode) {
        if (root == null || root.data == dNode) {
            return root;
        } else if (root.data > dNode) {
            return findNode(root.left, dNode);
        } else {
            return findNode(root.right, dNode);
        }
    }

    public Node17 findMinNode(Node17 node) {
        Node17 current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    public Node17 findMaxNode(Node17 node) {
        Node17 current = node;
        while (current.right != null) {
            current = current.right;
        }
        return current;
    }

    public Node17 deleteNode(Node17 root, int dNode) {
        if (root == null) {
            return root;
        }

        if (dNode < root.data) {
            root.left = deleteNode(root.left, dNode);
        } else if (dNode > root.data) {
            root.right = deleteNode(root.right, dNode);
        } else {
            // Case 1: Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Case 2: Node with two children, get the inorder successor or inorder predecessor (smallest in the right subtree)
            Node17 minNode = findMinNode(root.right);
            root.data = minNode.data;
            //(or)
            //Node17 maxNode = findMaxNode(root.left);
            //root.data= maxNode.data;

            // Delete the inorder successor
            root.right = deleteNode(root.right, minNode.data);
        }

        return root;
    }

    public void inorderTraversal(Node17 root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        System.out.println(root.data);
        inorderTraversal(root.right);
    }

    public static void main(String[] args) {
        _18_Deleting_Element_in_BST tree = new _18_Deleting_Element_in_BST();
        tree.root = new Node17(5);
        tree.root.left = new Node17(2);
        tree.root.right = new Node17(8);
        tree.root.left.left = new Node17(1);
        tree.root.left.right = new Node17(3);
        tree.root.right.left = new Node17(7);
        tree.root.right.right = new Node17(9);

        int deleteValue = 3;
        tree.root = tree.deleteNode(tree.root, deleteValue);
        tree.inorderTraversal(tree.root);
    }
}
