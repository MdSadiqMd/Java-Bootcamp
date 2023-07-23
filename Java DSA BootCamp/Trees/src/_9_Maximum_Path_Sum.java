class Node8 {
    int data;
    Node8 left, right;

    public Node8(int data) {
        this.data = data;
        left = right = null;
    }
}

public class _9_Maximum_Path_Sum {
    Node8 root;

    _9_Maximum_Path_Sum() {
        root = null;
    }

    public int MaxSum(Node8 root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return root.data;
        } else {
            int lSum = MaxSum(root.left);
            int rSum = MaxSum(root.right);
            int sum = Math.max(root.data, Math.max(lSum + root.data, rSum + root.data));
            int maxSum = Math.max(sum, lSum + rSum + root.data);
            return maxSum;
        }
    }

    public static void main(String[] args) {
        // Test Case 1: Binary Tree with single node
        _9_Maximum_Path_Sum tree1 = new _9_Maximum_Path_Sum();
        tree1.root = new Node8(10);
        int result1 = tree1.MaxSum(tree1.root);
        System.out.println("Test Case 1: " + result1); // Output should be 10

        // Test Case 2: Binary Tree with a single branch
        _9_Maximum_Path_Sum tree2 = new _9_Maximum_Path_Sum();
        tree2.root = new Node8(1);
        tree2.root.right = new Node8(2);
        tree2.root.right.right = new Node8(3);
        int result2 = tree2.MaxSum(tree2.root);
        System.out.println("Test Case 2: " + result2); // Output should be 6 (1 + 2 + 3)

        // Test Case 3: Binary Tree with negative values
        _9_Maximum_Path_Sum tree3 = new _9_Maximum_Path_Sum();
        tree3.root = new Node8(-10);
        tree3.root.left = new Node8(-5);
        tree3.root.right = new Node8(-15);
        tree3.root.left.left = new Node8(-20);
        tree3.root.left.right = new Node8(-8);
        int result3 = tree3.MaxSum(tree3.root);
        System.out.println("Test Case 3: " + result3); // Output should be -5 (only considering root and left branch)

        // Test Case 4: Binary Tree with positive and negative values
        _9_Maximum_Path_Sum tree4 = new _9_Maximum_Path_Sum();
        tree4.root = new Node8(1);
        tree4.root.left = new Node8(2);
        tree4.root.right = new Node8(3);
        tree4.root.left.left = new Node8(-2);
        tree4.root.left.right = new Node8(-3);
        tree4.root.right.left = new Node8(4);
        tree4.root.right.right = new Node8(-5);
        int result4 = tree4.MaxSum(tree4.root);
        System.out.println("Test Case 4: " + result4); // Output should be 7 (3 + 4)

        // Test Case 5: Binary Tree with a balanced structure
        _9_Maximum_Path_Sum tree5 = new _9_Maximum_Path_Sum();
        tree5.root = new Node8(10);
        tree5.root.left = new Node8(2);
        tree5.root.right = new Node8(10);
        tree5.root.left.left = new Node8(20);
        tree5.root.left.right = new Node8(1);
        tree5.root.right.right = new Node8(-25);
        tree5.root.right.right.left = new Node8(3);
        tree5.root.right.right.right = new Node8(4);
        int result5 = tree5.MaxSum(tree5.root);
        System.out.println("Test Case 5: " + result5); // Output should be 42 (20 + 2 + 10 + 10)

    }
}
