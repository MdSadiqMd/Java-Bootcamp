import java.util.Scanner;

public class _4_Reversing_a_Linked_List_Recursively {
    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    Node head; // head of the linked list

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

    public Node reverseList(Node current, Node previous) {
        if (current == null) {
            head = previous;
            return null;
        }

        Node next = current.next;
        current.next = previous;
        reverseList(next, current);
        return head;
    }

    public static void main(String[] args) {
        _4_Reversing_a_Linked_List_Recursively list = new _4_Reversing_a_Linked_List_Recursively(); // Create an instance of the class

        Scanner scanner = new Scanner(System.in);
        list.insertAtEnd(2);
        list.insertAtEnd(5);
        list.insertAtEnd(4);
        list.insertAtEnd(3);
        list.insertAtEnd(6);

        System.out.println("Original Linked List:");
        list.printList();

        list.reverseList(list.head, null);

        System.out.println("Reversed Linked List:");
        list.printList();
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}