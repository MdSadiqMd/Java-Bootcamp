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
    // Constructing Binary Tree with PreOrder and InOrder
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
    // Constructing Binary Tree with PostOrder and InOrder
    public static TreeNode constructTreePostOrder(int[] postOrder, int[] inOrder, HashMap<Integer, Integer> indexMap, int postOrderStart, int postOrderEnd, int inOrderStart, int inOrderEnd) {
        if (postOrderStart > postOrderEnd || inOrderStart > inOrderEnd) return null;
        int rootData = postOrder[postOrderEnd];
        int rootIndex = indexMap.get(rootData);
        TreeNode root = new TreeNode(rootData);
        int rightSubTreeSize = inOrderEnd - rootIndex;
        root.left = constructTreePostOrder(postOrder, inOrder, indexMap, postOrderStart, postOrderEnd - rightSubTreeSize - 1, inOrderStart, rootIndex - 1);
        root.right = constructTreePostOrder(postOrder, inOrder, indexMap, postOrderEnd - rightSubTreeSize, postOrderEnd - 1, rootIndex + 1, inOrderEnd);
        return root;
    }
    public static void main(String[] args) {
        int[] preOrder = { 3, 9, 20, 15, 7 };
        int[] postOrder = { 9, 15, 7, 20, 3 };
        int[] inOrder = { 9, 3, 15, 20, 7 };
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            indexMap.put(inOrder[i], i);
        }
        int n = preOrder.length - 1;
        int m = inOrder.length - 1;
        int o = postOrder.length - 1;
        TreeNode root = constructTree(preOrder, inOrder, indexMap, 0, n, 0, m);
        TreeNode root1 = constructTreePostOrder(postOrder, inOrder, indexMap, 0, n, 0, o);
        printInOrder(root);
        System.out.println();
        printInOrder(root1);
    }
    static void printInOrder(TreeNode root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }
}
