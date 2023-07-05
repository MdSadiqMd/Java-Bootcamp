import java.util.HashSet;
import java.util.Scanner;

public class _7_Duplicates_in_a_Linked_List {
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

    public void removeDuplicates() {
        if (head == null || head.next == null) {
            return;
        }

        HashSet<Integer> set = new HashSet<>();
        Node current = head;
        Node previous = null;

        while (current != null) {
            if (set.contains(current.data)) {
                previous.next = current.next;
            } else {
                set.add(current.data);
                previous = current;
            }
            current = current.next;
        }
    }

    public static void main(String[] args) {
        _7_Duplicates_in_a_Linked_List list = new _7_Duplicates_in_a_Linked_List(); // Create an instance of the class

        Scanner scanner = new Scanner(System.in);
        list.insertAtEnd(2);
        list.insertAtEnd(5);
        list.insertAtEnd(5);
        list.insertAtEnd(4);
        list.insertAtEnd(3);
        list.insertAtEnd(6);

        System.out.println("Original Linked List:");
        list.printList();

        list.removeDuplicates();

        System.out.println("Linked List after removing duplicates:");
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
