public class Swap_Nodes_in_Pairs {
    static class Node {
        int data;
        Node next;
        public Node(int d) {
            data = d;
            next = null;
        }
    }

    public static Node swap(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node first=head;
        Node second=head.next;

        first.next=swap(second.next);
        second.next=first;

        return second;
    }

    public static void main(String[] args) {
        Node l = new Node(1);
        l.next = new Node(2);
        l.next.next = new Node(3);
        l.next.next.next = new Node(4);

        Node result=swap(l);
        while (result!=null){
            System.out.print(result.data +" -> ");
            result=result.next;
        }
        System.out.print("null");
    }
}
