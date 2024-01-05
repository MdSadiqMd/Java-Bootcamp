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
        reorderListHelper(head.next);
    }
    private void reorderListHelper(Node node) {
        // Base case: If the current node is null or the next node is null, stop the recursion
        if (node == null || node.next == null) {
            return;
        }

        // Recursive call: Move to the next node in the list
        reorderListHelper(node.next.next);

        // Reordering logic during the backtracking phase
        Node temp = current.next;
        current.next = node.next;
        node.next = null; // Set next of the current node to null to avoid infinite loop
        current.next.next = temp;
        current = temp;
    }
    public static void main(String[] args) {
        ReOrder_List reorderList = new ReOrder_List();
        Node list = new Node(1);
        list.next = new Node(2);
        list.next.next = new Node(3);
        list.next.next.next = new Node(4);
        // Create a separate pointer to the head of the list
        Node originalList = list;
        // Call the reorderList method to initiate the reordering
        reorderList.reorderList(list);

        while (originalList != null) {
            System.out.print(originalList.data + " -> ");
            originalList = originalList.next;
        }
        System.out.println("null");
    }
}
