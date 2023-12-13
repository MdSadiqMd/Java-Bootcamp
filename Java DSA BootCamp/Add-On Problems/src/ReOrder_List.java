public class ReOrder_List {
    static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    private Node current;
    public void reorderList(Node head) {
        if (head == null || head.next == null) {
            return;
        }
        current = head;
        reorderListHelper(head);
    }
    private void reorderListHelper(Node node) {
        // Base case: If the current node is null, stop the recursion
        if (node == null) {
            return;
        }
        // Recursive call: Move to the next node in the list
        reorderListHelper(node.next);
        // Reordering logic during the backtracking phase
        if (current != node && current.next != null) {
            Node temp = current.next;
            current.next = node;
            node.next = temp;
            current = temp;
        } else {
            current.next = null; // Set next of the last node to null
        }
    }

    public static void main(String[] args) {
        ReOrder_List reorderList = new ReOrder_List();
        Node list = new Node(1);
        list.next = new Node(2);
        list.next.next = new Node(3);
        list.next.next.next = new Node(4);
        // Call the reorderList method to initiate the reordering
        reorderList.reorderList(list);
        // Print the modified list
        while (list != null) {
            System.out.print(list.data + " -> ");
            list = list.next;
        }
        System.out.println("null");
    }
}
