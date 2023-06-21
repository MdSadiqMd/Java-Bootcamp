public class _1_Insertion_in_Node {
    class LinkedList {
        Node head;

        class Node {
            int data;
            Node next;

            Node(int d) {
                data = d;
                next = null;
            }
        }

        public void InsertAtEnd(int newData) {
            Node newNode = new Node(newData);
            // If Linked List is Empty
            if (head == null) {
                head = newNode;
                return;
            }
            // If Linked List is not Empty
            newNode.next = null;
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }

        public void PrintNodes() {
            Node current = head;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
        }
    }

    public static void main(String[] args) {
        _1_Insertion_in_Node.LinkedList list = new _1_Insertion_in_Node().new LinkedList();
        list.InsertAtEnd(2);
        list.InsertAtEnd(5);
        list.InsertAtEnd(4);
        list.InsertAtEnd(3);
        list.InsertAtEnd(6);
        list.PrintNodes();
    }
}
