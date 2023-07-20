public class _1_Insertion_in_Node {
    static class LinkedList {
        Node head;
        class Node {
            int data;
            Node next;
            Node(int d) {
                data = d;
                next = null;
            }
        }

        public void insertAtEnd(int newData) {
            Node newNode = new Node(newData);
            // If Linked List is Empty
            if (head == null) {
                head = newNode;
                return;
            }
            // If Linked List is not Empty
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }

        public void insertAtBegin(int newData){
            Node newNode=new Node(newData);
            newNode.next=head;
            head=newNode;
        }

        public void insertAfter(Node prevNode,int newData){
            if(prevNode == null){
                System.out.println("Previous node can't be null. Please provide a valid node.");
                return;
            }
            Node newNode=new Node(newData);
            newNode.next=prevNode.next;
            prevNode.next=newNode;
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
        _1_Insertion_in_Node.LinkedList list = new LinkedList();
        list.insertAtEnd(2);
        list.insertAtEnd(5);
        list.insertAtEnd(4);
        list.insertAtEnd(3);
        list.insertAtEnd(6);
        list.insertAtBegin(1);
        list.insertAfter(list.head.next.next, 13);
        list.printNodes();
    }
}
