public class Remove_Nth_Node_from_the_End_of_the_List {
    static class LinkedList {
        Node head;

        static class Node {
            int data;
            Node next;

            public Node(int d) {
                data = d;
                next = null;
            }
        }

        public void insertAtEnd(int newData) {
            Node newNode = new Node(newData);
            if (head == null) {
                head = newNode;
                return;
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
        }

        public void removing(int k) {
            Node fast = head;
            Node slow = head;

            // Move the fast pointer k nodes ahead
            for (int i = 0; i < k; i++) {
                if (fast == null) {
                    return; // The list has less than k nodes
                }
                fast = fast.next;
            }

            // If fast reaches the end, remove the head
            if (fast == null) {
                head = head.next;
                return;
            }

            // Move fast to the end while keeping slow k nodes behind
            while (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }

            // Remove the nth node from the end
            slow.next = slow.next.next;
        }
        public void printNodes() {
            Node current = head;
            while (current != null) {
                System.out.print(current.data + " -> ");
                current = current.next;
            }
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAtEnd(4);
        list.insertAtEnd(5);
        list.printNodes();
        int n = 2;
        list.removing(n);
        list.printNodes();
    }
}
