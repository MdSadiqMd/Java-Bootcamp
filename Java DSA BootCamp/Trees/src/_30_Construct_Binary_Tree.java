import java.util.HashMap;

public class _30_Construct_Binary_Tree {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }
    public static TreeNode constructTree(int[] preOrder, int[] inOrder, HashMap<Integer, Integer> indexMap, int preOrderStart, int preOrderEnd, int inOrderStart, int inOrderEnd) {
        if (preOrderStart > preOrderEnd || inOrderStart > inOrderEnd) return null;
        int rootData = preOrder[preOrderStart];
        int rootIndex = indexMap.get(rootData);
        TreeNode root = new TreeNode(rootData);
        int leftSubTreeSize = rootIndex - inOrderStart;
        root.left = constructTree(preOrder, inOrder, indexMap, preOrderStart + 1, preOrderStart + leftSubTreeSize, inOrderStart, rootIndex - 1);
        root.right = constructTree(preOrder, inOrder, indexMap, preOrderStart + leftSubTreeSize + 1, preOrderEnd, rootIndex + 1, inOrderEnd);
        return root;
    }

    public static void main(String[] args) {
        int[] preOrder = { 3, 9, 20, 15, 7 };
        int[] inOrder = { 9, 3, 15, 20, 7 };
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            indexMap.put(inOrder[i], i);
        }
        int n = preOrder.length - 1;
        int m = inOrder.length - 1;
        TreeNode root = constructTree(preOrder, inOrder, indexMap, 0, n, 0, m);
        printInOrder(root);
    }
    static void printInOrder(TreeNode root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }
}
