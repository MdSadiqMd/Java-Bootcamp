import java.util.Scanner;

public class _2_Deleting_a_Node {
    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    class LinkedList {
        Node head;

        public void insertAtEnd(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                return;
            }

            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }

        public void deletion(int position) {
            if (head == null) {
                return;
            }
            if (position == 0) {
                head = head.next;
                return;
            }
            Node temp = head;
            for (int i = 0; temp != null && i < position - 1; i++) {
                temp = temp.next;
            }
            if (temp == null || temp.next == null) {
                return;
            }
            temp.next = temp.next.next;
        }
    }

    public static void main(String[] args) {
        _2_Deleting_a_Node deletingNode = new _2_Deleting_a_Node();
        LinkedList list = deletingNode.new LinkedList();

        Scanner scanner = new Scanner(System.in);
        list.insertAtEnd(2);
        list.insertAtEnd(5);
        list.insertAtEnd(4);
        list.insertAtEnd(3);
        list.insertAtEnd(6);

        // Perform deletion at a specific position
        System.out.print("Enter the position to delete: ");
        int position = scanner.nextInt();
        list.deletion(position);

        // Print the updated linked list
        Node temp = list.head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
