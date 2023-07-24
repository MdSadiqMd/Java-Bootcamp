import java.util.*;

class Node18 {
    int data;
    Node18 left, right;

    public Node18(int data) {
        this.data = data;
        left = right = null;
    }
}

public class _19_Kth_Smallest_Element_in_BST {
    Node18 root;

    _19_Kth_Smallest_Element_in_BST() {
        root = null;
    }

    public List<Integer> findMin(Node18 root, List<Integer> result) {
        if (root == null) {
            return result;
        }

        findMin(root.left, result);
        result.add(root.data);
        findMin(root.right, result);

        return result;
    }

    public int kthSmallest(Node18 root, int k) {
        List<Integer> sortedList = findMin(root, new ArrayList<>());
        if (k > 0 && k <= sortedList.size()) {
            return sortedList.get(k - 1);
        }
        return -1;
    }

    public static void main(String[] args) {
        _19_Kth_Smallest_Element_in_BST tree = new _19_Kth_Smallest_Element_in_BST();
        tree.root = new Node18(5);
        tree.root.left = new Node18(2);
        tree.root.right = new Node18(8);
        tree.root.left.left = new Node18(1);
        tree.root.left.right = new Node18(3);
        tree.root.right.left = new Node18(7);
        tree.root.right.right = new Node18(9);

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Value of k : ");
        int k = sc.nextInt();

        int kthSmallestElement = tree.kthSmallest(tree.root, k);
        System.out.println("Kth Smallest Element: " + kthSmallestElement);
    }
}
