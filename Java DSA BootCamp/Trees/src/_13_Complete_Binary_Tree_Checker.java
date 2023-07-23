import java.util.Objects;

// Complete Binary Tree Checker
class Node12 {
    int data;
    Node12 left, right;

    public Node12(int data) {
        this.data = data;
        left = right = null;
    }
}

public class _13_Complete_Binary_Tree_Checker {
    Node12 root;

    _13_Complete_Binary_Tree_Checker() {
        root = null;
    }

    public boolean Checker(Node12 root) {
        if (root == null) {
            return true;
        } else if (Objects.isNull(root.left) && Objects.isNull(root.right)) {
            return true;
        } else if (Objects.isNull(root.left) || Objects.isNull(root.right)) {
            return false;
        } else {
            return Checker(root.left) && Checker(root.right);
        }
    }

    public static void main(String[] args) {
        _13_Complete_Binary_Tree_Checker tree = new _13_Complete_Binary_Tree_Checker();
        tree.root = new Node12(5);
        tree.root.left = new Node12(2);
        tree.root.right = new Node12(8);
        tree.root.left.left = new Node12(1);
        tree.root.left.right = new Node12(3);
        tree.root.right.left = new Node12(7);
        tree.root.right.right = new Node12(9);
        boolean result = tree.Checker(tree.root);
        System.out.println(result);
    }
}
