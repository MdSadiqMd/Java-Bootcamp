public class Remove_Linked_List_Elements {
    static class Node{
        Node head;
        Node next;
        int data;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static void remove(Node node, int val) {
        // Handle the case where the value to be removed is at the beginning of the list
        /*while (node != null && node.data == val) {
            node = node.next;
        }

        Node ptr1 = node;
        Node ptr2 = (node != null) ? node.next : null;

        while (ptr2 != null) {
            if (ptr2.data == val) {
                ptr1.next = ptr2.next;
                ptr2 = ptr2.next; // Move ptr2 forward without moving ptr1
            } else {
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
            }
        }*/

        // Recursive Solution
        if (node == null) {
            return;
        }
        // Recursively remove elements from the rest of the list
        remove(node.next, val);
        // Check if the current node's data matches the value to be removed
        if (node.next != null && node.next.data == val) {
            node.next = node.next.next;
        }
    }

    public static void main(String[] args) {
        int n=3;
        Node list=new Node(1);
        list.next=new Node(2);
        list.next.next=new Node(3);
        list.next.next.next=new Node(4);
        list.next.next.next.next=new Node(3);
        remove(list,n);
        Node current=list;
        while(current!=null){
            System.out.print(current.data+" -> ");
            current=current.next;
        }
        System.out.println("null");
    }
}
