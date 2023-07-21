public class _10_Circular_Linked_List {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class CircularLinkedList {
        Node head;

        public void insertAtStart(int newData) {
            Node newNode = new Node(newData);
            if (head == null) {
                head = newNode;
                head.next = head; // The list is circular, so the head points to itself.
            } else {
                newNode.next = head;
                Node current = head;
                while (current.next != head) {
                    current = current.next;
                }
                current.next = newNode;
                head = newNode;
            }
        }

        public void insertAtMiddle(int newData) {
            Node newNode = new Node(newData);
            if (head == null) {
                head = newNode;
                head.next = head; // The list is circular, so the head points to itself.
            } else {
                Node slowPtr = head;
                Node fastPtr = head;
                while (fastPtr.next != head && fastPtr.next.next != head) {
                    slowPtr = slowPtr.next;
                    fastPtr = fastPtr.next.next;
                }
                newNode.next = slowPtr.next;
                slowPtr.next = newNode;
            }
        }

        public void insertAtAnyPlace(int data, int newData) {
            Node newNode = new Node(newData);
            if (head == null) {
                head = newNode;
                head.next = head; // The list is circular, so the head points to itself.
            } else {
                Node current = head;
                while (current.next != head) {
                    if (current.data == data) {
                        newNode.next = current.next;
                        current.next = newNode;
                        return;
                    }
                    current = current.next;
                }
                if (current.data == data) {
                    newNode.next = current.next;
                    current.next = newNode;
                }
            }
        }

        public void delete(int data) {
            if (head == null) {
                return; // The list is empty, nothing to delete.
            }
            if (head.data == data) {
                Node current = head;
                while (current.next != head) {
                    current = current.next;
                }
                if (current == head) {
                    head = null; // If there is only one node, remove it.
                } else {
                    current.next = head.next;
                    head = head.next;
                }
                return; // Node found and deleted, exit the method.
            }

            Node current = head;
            Node prev = null;
            while (current.next != head) {
                if (current.data == data) {
                    prev.next = current.next;
                    return; // Node found and deleted, exit the method.
                }
                prev = current;
                current = current.next;
            }

            // Check the last node (tail) of the circular list
            if (current.data == data) {
                prev.next = head; // Make sure the "next" of the previous node points to the new head.
            }
        }
    }

    public static void main(String[] args) {
        // Test the circular linked list by inserting some elements
        CircularLinkedList circularLinkedList = new CircularLinkedList();
        circularLinkedList.insertAtStart(1);
        circularLinkedList.insertAtStart(0);

        // Print the circular linked list
        Node current = circularLinkedList.head;
        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != circularLinkedList.head);
        System.out.println("head");

        // Test insertion at the middle
        circularLinkedList.insertAtMiddle(3);
        circularLinkedList.insertAtMiddle(2);

        // Print the circular linked list after insertion at the middle
        current = circularLinkedList.head;
        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != circularLinkedList.head);
        System.out.println("head");

        // Test insertion at any place
        circularLinkedList.insertAtAnyPlace(2, 2);
        circularLinkedList.insertAtAnyPlace(4, 4);

        // Print the circular linked list after insertion at any place
        current = circularLinkedList.head;
        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != circularLinkedList.head);
        System.out.println("head");

        // Test deletion
        circularLinkedList.delete(4);
        circularLinkedList.delete(0);

        // Print the circular linked list after deletion
        current = circularLinkedList.head;
        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != circularLinkedList.head);
        System.out.println("head");
    }
}
