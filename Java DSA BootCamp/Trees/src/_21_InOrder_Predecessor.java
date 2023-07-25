import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Node20 {
    int data;
    Node20 left, right;

    public Node20(int data) {
        this.data = data;
        left = right = null;
    }
}

public class _21_InOrder_Predecessor {
    Node20 root;

    _21_InOrder_Predecessor() {
        root = null;
    }

    public Node20 findNode(Node20 root, int element) {
        if (root == null || root.data == element) {
            return root;
        } else if (root.data > element) {
            return findNode(root.left, element);
        } else {
            return findNode(root.right, element);
        }
    }

    public Node20 findMax(Node20 node) {
        if (node == null || node.right == null) {
            return node;
        }
        return findMax(node.right);
    }

    public Node20 inOrderPredecessor(Node20 root, int element) {
        Node20 targetNode = findNode(root, element);

        if (targetNode == null) {
            // Element not found in the BST
            return null;
        }

        // If the left subtree of the target node is not empty, then the inorder
        // predecessor will be the rightmost node in the left subtree.
        if (targetNode.left != null) {
            return findMax(targetNode.left);
        } else {
            // If the left subtree is empty, then we need to find the ancestor node of the
            // target node where the path takes a right turn.
            Node20 predecessor = null;
            Node20 current = root;
            while (current != targetNode) {
                if (current.data < targetNode.data) {
                    predecessor = current;
                    current = current.right;
                } else {
                    current = current.left;
                }
            }
            return predecessor;
        }
    }

    public static void main(String[] args) {
        _21_InOrder_Predecessor tree = new _21_InOrder_Predecessor();
        tree.root = new Node20(5);
        tree.root.left = new Node20(2);
        tree.root.right = new Node20(8);
        tree.root.left.left = new Node20(1);
        tree.root.left.right = new Node20(3);
        tree.root.right.left = new Node20(7);
        tree.root.right.right = new Node20(9);

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Element:");
        int element = sc.nextInt();

        Node20 predecessor = tree.inOrderPredecessor(tree.root, element);

        if (predecessor != null) {
            System.out.println("Inorder Predecessor of " + element + " is: " + predecessor.data);
        } else {
            System.out.println("No inorder predecessor found for " + element);
        }
    }
}
