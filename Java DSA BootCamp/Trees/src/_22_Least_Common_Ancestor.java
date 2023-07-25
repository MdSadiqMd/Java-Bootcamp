import java.util.Scanner;

class Node21 {
    int data;
    Node21 left, right;

    public Node21(int data) {
        this.data = data;
        left = right = null;
    }
}

public class _22_Least_Common_Ancestor {
    Node21 root;

    _22_Least_Common_Ancestor() {
        root = null;
    }

    public int LCA(Node21 root, int n1, int n2) {
        if (root == null) {
            return -1; // No LCA found
        } else if (n1 > root.data && n2 > root.data) {
            return LCA(root.right, n1, n2);
        } else if (n1 < root.data && n2 < root.data) {
            return LCA(root.left, n1, n2);
        } else {
            return root.data; // Found LCA
        }
    }

    public static void main(String[] args) {
        _22_Least_Common_Ancestor tree = new _22_Least_Common_Ancestor();
        tree.root = new Node21(5);
        tree.root.left = new Node21(2);
        tree.root.right = new Node21(8);
        tree.root.left.left = new Node21(1);
        tree.root.left.right = new Node21(3);
        tree.root.right.left = new Node21(7);
        tree.root.right.right = new Node21(9);

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Element 1:");
        int n1 = sc.nextInt();
        System.out.println("Enter the Element 2:");
        int n2 = sc.nextInt();

        int result = tree.LCA(tree.root, n1, n2);
        System.out.println("Least Common Ancestor: " + result);
    }
}
