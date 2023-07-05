import java.util.Scanner;

public class _8_Palindrome_in_a_Linked_List {
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

    public Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    public boolean isPalindrome() {
        if (head == null || head.next == null) {
            return true;
        }

        // Finding the middle point using slow and fast pointers
        Node slow = head;
        Node fast = head;
        Node prevSlow = null;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prevSlow = slow;
            slow = slow.next;
        }

        // If the total number of nodes is odd, move slow one step further
        if (fast != null) {
            slow = slow.next;
        }

        // Reverse the second half of the linked list
        Node secondHalf = reverse(slow);
        prevSlow.next = null; // Disconnect the first half

        // Compare the first half and reversed second half for palindrome check
        Node p1 = head;
        Node p2 = secondHalf;

        while (p1 != null && p2 != null) {
            if (p1.data != p2.data) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // Reconstruct the original linked list by reversing the second half back
        secondHalf = reverse(secondHalf);
        prevSlow.next = secondHalf;

        return true;
    }

    public static void main(String[] args) {
        _8_Palindrome_in_a_Linked_List list = new _8_Palindrome_in_a_Linked_List(); // Create an instance of the class

        list.insertAtEnd(2);
        list.insertAtEnd(5);
        list.insertAtEnd(4);
        list.insertAtEnd(3);
        list.insertAtEnd(6);

        System.out.println("Original Linked List:");
        list.printList();
        System.out.println(list.isPalindrome());
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
