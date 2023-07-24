class Node16 {
    int data;
    Node16 left, right;

    public Node16(int data) {
        this.data = data;
        left = right = null;
    }
}

public class _17_Inserting_Element_in_BST {
    Node16 root;

    _17_Inserting_Element_in_BST() {
        root = null;
    }

    public Node16 insert(Node16 root, int data) {
        if (root == null) {
            return new Node16(data);
        } else if (data < root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return root;
    }

    public void inorderTraversal(Node16 root) {
        if (root == null) {
            return;
        } else {
            inorderTraversal(root.left);
            System.out.println(root.data);
            inorderTraversal(root.right);
        }
    }

    public static void main(String[] args) {
        _17_Inserting_Element_in_BST tree = new _17_Inserting_Element_in_BST();
        tree.root = tree.insert(tree.root, 5);
        tree.root = tree.insert(tree.root, 2);
        tree.root = tree.insert(tree.root, 8);
        tree.root = tree.insert(tree.root, 1);
        tree.root = tree.insert(tree.root, 3);
        tree.root = tree.insert(tree.root, 7);
        tree.root = tree.insert(tree.root, 9);
        tree.inorderTraversal(tree.root);
    }
}
