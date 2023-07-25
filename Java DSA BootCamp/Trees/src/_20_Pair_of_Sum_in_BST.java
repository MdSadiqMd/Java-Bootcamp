import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

class Node19 {
    int data;
    Node19 left, right;

    public Node19(int data) {
        this.data = data;
        left = right = null;
    }
}

public class _20_Pair_of_Sum_in_BST {
    Node19 root;

    _20_Pair_of_Sum_in_BST() {
        root = null;
    }

    public void sumPair(Node19 root, List<Integer> result, int value) {
        if (root == null) {
            return;
        }
        sumPair(root.left, result, value);
        if (root.data >= value) {
            return;
        }
        if (isPresent(root.left, value - root.data)) {
            result.add(root.data);
            result.add(value - root.data);
        }
        sumPair(root.right, result, value);
    }

    public Boolean isPresent(Node19 root, int value) {
        if (root == null) {
            return false;
        } else if (root.data == value) {
            return true;
        } else if (root.data >= value) {
            return isPresent(root.left, value);
        } else {
            return isPresent(root.right, value) || isPresent(root.left, value);
        }
    }

    public static void main(String[] args) {
        _20_Pair_of_Sum_in_BST tree = new _20_Pair_of_Sum_in_BST();
        tree.root = new Node19(5);
        tree.root.left = new Node19(2);
        tree.root.right = new Node19(8);
        tree.root.left.left = new Node19(1);
        tree.root.left.right = new Node19(3);
        tree.root.right.left = new Node19(7);
        tree.root.right.right = new Node19(9);

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Value: ");
        int n = sc.nextInt();

        List<Integer> result = new ArrayList<>();
        tree.sumPair(tree.root, result, n);
        System.out.println(result);
    }
}
