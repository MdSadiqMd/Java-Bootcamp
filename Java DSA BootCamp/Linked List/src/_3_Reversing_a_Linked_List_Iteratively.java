import java.util.Scanner;

public class _3_Reversing_a_Linked_List_Iteratively {
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

    public Node Reversing(Node head) {
        if (head == null) {
            return null;
        }

        Node prevNode = null;
        Node currNode = head;
        Node nextNode = null;

        while (currNode != null) {
            nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }

        head = prevNode;
        return head;
    }

    public static void main(String[] args) {
        _3_Reversing_a_Linked_List_Iteratively list = new _3_Reversing_a_Linked_List_Iteratively(); // Create an instance of the class

        Scanner scanner = new Scanner(System.in);
        list.insertAtEnd(2);
        list.insertAtEnd(5);
        list.insertAtEnd(4);
        list.insertAtEnd(3);
        list.insertAtEnd(6);

        Node reversedHead = list.Reversing(list.head);
        Node temp = reversedHead;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
