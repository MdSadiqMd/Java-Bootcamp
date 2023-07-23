import java.util.Scanner;

class Node10 {
    int data;
    Node10 left, right;

    public Node10(int data) {
        this.data = data;
        left = right = null;
    }
}

public class _11_Searching_in_BST {
    Node10 root;

    _11_Searching_in_BST() {
        root = null;
    }

    public boolean isPresent(Node10 root, int val) {
        if (root == null) {
            return false;
        } else if (root.data == val) {
            return true;
        } else if (root.data < val) {
            return isPresent(root.right, val); // Corrected from root.left.data to root.right
        } else {
            return isPresent(root.left, val); // Corrected from root.right.data to root.left
        }
    }

    public static void main(String[] args) {
        _11_Searching_in_BST tree = new _11_Searching_in_BST();
        tree.root = new Node10(5);
        tree.root.left = new Node10(2);
        tree.root.right = new Node10(8);
        tree.root.left.left = new Node10(1);
        tree.root.left.right = new Node10(3);
        tree.root.right.left = new Node10(7);
        tree.root.right.right = new Node10(9);

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Value to be Searched: ");
        int val = sc.nextInt();

        boolean result = tree.isPresent(tree.root, val);
        if (result) {
            System.out.println("The Value is present in the BST.");
        } else {
            System.out.println("The Value is not present in the BST.");
        }
    }
}
