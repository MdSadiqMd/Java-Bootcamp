class Node1 {
    int data;
    Node1 left;
    Node1 right;
    public Node1(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class _4_Max_Heap_Linked_List {
    private Node1 root;

    public _4_Max_Heap_Linked_List() {
        this.root = null;
    }

    public void insert(int value) {
        if (root == null) {
            root = new Node1(value);
        } else {
            insertUtil(root, value);
        }
    }

    private void insertUtil(Node1 node, int value) {
        if (node.left == null) {
            node.left = new Node1(value);
        } else if (node.right == null) {
            node.right = new Node1(value);
        } else {
            if (countNodes(node.left) <= countNodes(node.right)) {
                insertUtil(node.left, value);
            } else {
                insertUtil(node.right, value);
            }
        }

        heapifyUp(node);
    }

    private void heapifyUp(Node1 node) {
        if (node == root) {
            return;
        }

        Node1 parent = findParent(root, node);
        if (node.data > parent.data) {
            swap(node, parent);
            heapifyUp(parent);
        }
    }

    public int extractMax() {
        if (root == null) {
            throw new IllegalStateException("Heap is empty.");
        }

        int max = root.data;

        Node1 lastNode = getLastNode();
        if (lastNode != root) {
            root.data = lastNode.data;
            removeLastNode(root);
            heapifyDown(root);
        } else {
            root = null;
        }

        return max;
    }

    private Node1 getLastNode() {
        if (root == null) {
            return null;
        }

        int height = (int) (Math.log(countNodes(root) + 1) / Math.log(2));
        Node1 lastNodeParent = findLastNodeParent(root, height);
        return (countNodes(root) % 2 == 0) ? lastNodeParent.right : lastNodeParent.left;
    }

    private Node1 findParent(Node1 current, Node1 target) {
        if (current == null || current.left == target || current.right == target) {
            return current;
        }

        Node1 parent = findParent(current.left, target);
        if (parent != null) {
            return parent;
        }

        return findParent(current.right, target);
    }

    private void removeLastNode(Node1 node) {
        if (node.left == null) {
            return;
        }

        if (node.right == null) {
            node.left = null;
        } else {
            removeLastNode(node.right);
        }
    }

    private void heapifyDown(Node1 node) {
        if (node.left == null) {
            return;
        }

        Node1 maxChild = node.left;
        if (node.right != null && node.right.data > node.left.data) {
            maxChild = node.right;
        }

        if (maxChild.data > node.data) {
            swap(node, maxChild);
            heapifyDown(maxChild);
        }
    }

    private int countNodes(Node1 node) {
        if (node == null) {
            return 0;
        }

        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    private Node1 findLastNodeParent(Node1 node, int height) {
        if (height == 1) {
            return node;
        }

        if (countNodes(node.right) < (1 << (height - 1))) {
            return findLastNodeParent(node.left, height - 1);
        } else {
            return findLastNodeParent(node.right, height - 1);
        }
    }

    private void swap(Node1 node1, Node1 node2) {
        int temp = node1.data;
        node1.data = node2.data;
        node2.data = temp;
    }

    public static void main(String[] args) {
        _4_Max_Heap_Linked_List maxHeap = new _4_Max_Heap_Linked_List();
        maxHeap.insert(5);
        maxHeap.insert(7);
        maxHeap.insert(3);
        maxHeap.insert(10);
        maxHeap.insert(1);

        System.out.println("Max element: " + maxHeap.extractMax());
        System.out.println("Max element: " + maxHeap.extractMax());
    }
}
