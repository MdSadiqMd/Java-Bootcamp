class Node9 {
    int data;
    Node9 left, right;

    public Node9(int data) {
        this.data = data;
        left = right = null;
    }
}

public class _10_Validate_BST {
    Node9 root;

    _10_Validate_BST() {
        root = null;
    }

    public int[] InOrder(Node9 root) {
        if (root == null) {
            return new int[]{};
        } else {
            int[] leftResult = InOrder(root.left);
            System.out.println(root.data);
            int[] rightResult = InOrder(root.right);
            return mergeArrays(leftResult, new int[]{root.data}, rightResult);
        }
    }

    public int[] mergeArrays(int[] arr1, int[] arr2, int[] arr3) {
        int[] result = new int[arr1.length + arr2.length + arr3.length];
        int i = 0, j = 0, k = 0, idx = 0;

        while (i < arr1.length) {
            result[idx++] = arr1[i++];
        }
        while (j < arr2.length) {
            result[idx++] = arr2[j++];
        }
        while (k < arr3.length) {
            result[idx++] = arr3[k++];
        }

        return result;
    }

    public boolean isSorted(int[] result) {
        for (int i = 0; i < result.length - 1; i++) {
            if (result[i] >= result[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        _10_Validate_BST tree = new _10_Validate_BST();
        tree.root = new Node9(5);
        tree.root.left = new Node9(2);
        tree.root.right = new Node9(8);
        tree.root.left.left = new Node9(1);
        tree.root.left.right = new Node9(3);
        tree.root.right.left = new Node9(7);
        tree.root.right.right = new Node9(9);

        int[] result = tree.InOrder(tree.root);
        int count = 0;
        for (int i = 0; i < result.length; i++) {
            for (int j = i + 1; j < result.length; j++) {
                int ele = result[i];
                if (ele == result[j]) {
                    count++;
                }
            }
        }
        boolean sort = tree.isSorted(result);
        if (sort == true) {
            count++;
        }
        if (count > 0) {
            System.out.println("The Given Tree Satisfy BST Conditions");
        } else {
            System.out.println("The Given Tree is not a BST");
        }
    }
}
