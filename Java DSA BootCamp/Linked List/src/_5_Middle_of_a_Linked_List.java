import java.util.Scanner;

public class _5_Middle_of_a_Linked_List {
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

    public Object MiddleElement(Node data){
        Node ptr1=data;
        Node ptr2=data;
        if(head==null){
            return 0;
        }
        if(head.next==null){
            return 1;
        }
        while(ptr1!=null && ptr2.next!=null){
            ptr1=ptr1.next;
            ptr2=ptr2.next.next;
        }
        return ptr1.data;
    }

    public static void main(String[] args) {
        _5_Middle_of_a_Linked_List list = new _5_Middle_of_a_Linked_List(); // Create an instance of the class

        Scanner scanner = new Scanner(System.in);
        list.insertAtEnd(2);
        list.insertAtEnd(5);
        list.insertAtEnd(4);
        list.insertAtEnd(3);
        list.insertAtEnd(6);

        System.out.println("Original Linked List:");
        list.printList();
        System.out.println(list.MiddleElement(list.head));
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
