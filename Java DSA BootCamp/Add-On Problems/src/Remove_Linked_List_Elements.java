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
    public static void main(String[] args) {
        int n=6;
        Node list=new Node(1);
        list.next=new Node(2);
        list.next.next=new Node(3);
        list.next.next.next=new Node(4);
        list.next.next.next.next=new Node(3);
    }
}
