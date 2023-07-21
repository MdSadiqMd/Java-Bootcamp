public class _9_Double_Linked_List {

    static class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    static class DoublyLinkedList {
        Node head;
        Node tail;

        public void insertAtStart(int newData) {
            Node newNode = new Node(newData);
            if (head == null) {
                head = newNode;
                tail = newNode; // Since it's the only node, it's both head and tail.
            } else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
        }

        public void insertAfter(int data, int newData) {
            Node newNode = new Node(newData);
            Node current = head;
            while (current != null) {
                if (current.data == data) {
                    newNode.next = current.next;
                    if (current.next != null) {
                        current.next.prev = newNode;
                    } else {
                        // If the node to insert after is the tail node
                        tail = newNode;
                    }
                    current.next = newNode;
                    newNode.prev = current;
                    return; // Node inserted, exit the method.
                }
                current = current.next;
            }
        }

        public void insertAtEnd(int newData) {
            Node newNode = new Node(newData);
            if (head == null) {
                head = newNode;
                tail = newNode; // Since it's the only node, it's both head and tail.
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
        }

        public void delete(int data) {
            Node current = head;
            while (current != null) {
                if (current.data == data) {
                    // If the node to delete is the head node
                    if (current == head) {
                        head = head.next;
                        if (head != null) {
                            head.prev = null;
                        } else {
                            // If the list becomes empty after deletion
                            tail = null;
                        }
                    } else if (current == tail) {
                        // If the node to delete is the tail node
                        tail = tail.prev;
                        tail.next = null;
                    } else {
                        // If the node to delete is in the middle of the list
                        current.prev.next = current.next;
                        current.next.prev = current.prev;
                    }
                    return; // Node found and deleted, exit the method.
                }
                current = current.next;
            }
        }
    }

    public static void main(String[] args) {
        // Test the linked list by inserting some elements
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.insertAtEnd(1);
        doublyLinkedList.insertAtEnd(2);
        doublyLinkedList.insertAtEnd(4);

        // Print the linked list forwards
        Node current = doublyLinkedList.head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");

        // Print the linked list backwards
        Node tail = doublyLinkedList.tail;
        while (tail != null) {
            System.out.print(tail.data + " -> ");
            tail = tail.prev;
        }
        System.out.println("null");

        // Test insertion at the start
        doublyLinkedList.insertAtStart(0);
        doublyLinkedList.insertAtStart(-1);

        // Print the linked list after insertion at the start
        current = doublyLinkedList.head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");

        // Test insertion after a node
        doublyLinkedList.insertAfter(2, 3);

        // Print the linked list after insertion after a node
        current = doublyLinkedList.head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");

        // Test deletion
        doublyLinkedList.delete(4);

        // Print the linked list after deletion
        current = doublyLinkedList.head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
