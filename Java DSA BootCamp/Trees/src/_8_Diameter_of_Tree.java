// Diameter means the Longest Tree Path which may or may not contain the Root Node
class Node7 {
    int data;
    Node7 left, right;

    public Node7(int data) {
        this.data = data;
        left = right = null;
    }
}

public class _8_Diameter_of_Tree {
    Node7 root;

    _8_Diameter_of_Tree() {
        root = null;
    }

    public int Diameter(Node7 root) {
        int diameter[] = new int[1]; // Initialize the diameter array
        DiameterLength(root, diameter);
        return diameter[0];
    }

    public int DiameterLength(Node7 root, int[] diameter) {
        if (root == null) {
            return 0;
        } else {
            int lDepth = DiameterLength(root.left, diameter);
            int rDepth = DiameterLength(root.right, diameter);
            diameter[0] = Math.max(diameter[0], lDepth + rDepth);
            return 1 + Math.max(lDepth, rDepth);
        }
    }

    public static void main(String[] args) {
        _8_Diameter_of_Tree tree = new _8_Diameter_of_Tree();
        tree.root = new Node7(1);
        tree.root.left = new Node7(2);
        tree.root.right = new Node7(3);
        tree.root.left.left = new Node7(4);
        tree.root.right.left = new Node7(5);
        tree.root.right.right = new Node7(6);
        tree.root.right.left.left = new Node7(7);
        tree.root.right.left.right = new Node7(8);

        int result = tree.Diameter(tree.root); // Call Diameter method instead of DiameterLength
        System.out.println(result);
    }
}
