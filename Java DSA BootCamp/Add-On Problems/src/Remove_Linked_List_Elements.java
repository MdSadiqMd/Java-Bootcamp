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
    public static void remove(Node node,int val){
        Node ptr1=node;
        Node ptr2=node.next;
        while(ptr2!=null && ptr2.data!=val){
            ptr1=ptr1.next;
            ptr2=ptr2.next;
        }
        ptr1.next=ptr2.next;
        ptr2.next=null;
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
