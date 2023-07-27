class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class _3_Min_Heap_Linked_List {
    private Node root;

    public _3_Min_Heap_Linked_List() {
        this.root = null;
    }

    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
        } else {
            insertUtil(root, value);
        }
    }

    private void insertUtil(Node node, int value) {
        if (node.left == null) {
            node.left = new Node(value);
        } else if (node.right == null) {
            node.right = new Node(value);
        } else {
            if (countNodes(node.left) <= countNodes(node.right)) {
                insertUtil(node.left, value);
            } else {
                insertUtil(node.right, value);
            }
        }

        heapifyUp(node);
    }

    private void heapifyUp(Node node) {
        if (node == root) {
            return;
        }

        Node parent = findParent(root, node);
        if (node.data < parent.data) {
            swap(node, parent);
            heapifyUp(parent);
        }
    }

    public int extractMin() {
        if (root == null) {
            throw new IllegalStateException("Heap is empty.");
        }

        int min = root.data;

        Node lastNode = getLastNode();
        if (lastNode != root) {
            root.data = lastNode.data;
            removeLastNode(root);
            heapifyDown(root);
        } else {
            root = null;
        }

        return min;
    }

    private Node getLastNode() {
        if (root == null) {
            return null;
        }

        int height = (int) (Math.log(countNodes(root) + 1) / Math.log(2));
        Node lastNodeParent = findLastNodeParent(root, height);
        return (countNodes(root) % 2 == 0) ? lastNodeParent.right : lastNodeParent.left;
    }

    private Node findParent(Node current, Node target) {
        if (current == null || current.left == target || current.right == target) {
            return current;
        }

        Node parent = findParent(current.left, target);
        if (parent != null) {
            return parent;
        }

        return findParent(current.right, target);
    }

    private void removeLastNode(Node node) {
        if (node.left == null) {
            return;
        }

        if (node.right == null) {
            node.left = null;
        } else {
            removeLastNode(node.right);
        }
    }

    private void heapifyDown(Node node) {
        if (node.left == null) {
            return;
        }

        Node minChild = node.left;
        if (node.right != null && node.right.data < node.left.data) {
            minChild = node.right;
        }

        if (minChild.data < node.data) {
            swap(node, minChild);
            heapifyDown(minChild);
        }
    }

    private int countNodes(Node node) {
        if (node == null) {
            return 0;
        }

        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    private Node findLastNodeParent(Node node, int height) {
        if (height == 1) {
            return node;
        }

        if (countNodes(node.right) < (1 << (height - 1))) {
            return findLastNodeParent(node.left, height - 1);
        } else {
            return findLastNodeParent(node.right, height - 1);
        }
    }

    private void swap(Node node1, Node node2) {
        int temp = node1.data;
        node1.data = node2.data;
        node2.data = temp;
    }

    public static void main(String[] args) {
        _3_Min_Heap_Linked_List minHeap = new _3_Min_Heap_Linked_List();
        minHeap.insert(5);
        minHeap.insert(7);
        minHeap.insert(3);
        minHeap.insert(10);
        minHeap.insert(1);

        System.out.println("Min element: " + minHeap.extractMin());
        System.out.println("Min element: " + minHeap.extractMin());
    }
}
