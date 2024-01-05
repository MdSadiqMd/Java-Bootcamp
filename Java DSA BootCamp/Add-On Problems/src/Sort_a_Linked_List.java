public class Sort_a_Linked_List {
    static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static Node sort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node mid = findMiddle(head);
        Node left = head;
        Node right = mid.next;
        mid.next = null;
        left = sort(left);
        right = sort(right);
        return merge(left, right);
    }
    public static Node merge(Node left, Node right) {
        if (left == null) return right;
        if (right == null) return left;
        Node dummy = new Node(-1);
        Node temp = dummy;
        while (left != null && right != null) {
            if (left.data < right.data) {
                temp.next = left;
                temp = left;
                left = left.next;
            } else {
                temp.next = right;
                temp = right;
                right = right.next;
            }
        }
        if (left != null) temp.next = left;
        else temp.next = right;
        return dummy.next;
    }
    public static Node findMiddle(Node head) {
        Node slowPtr = head;
        Node fastPtr = head;

        while (fastPtr.next != null && fastPtr.next.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        return slowPtr;
    }
    public static void main(String[] args) {
        Sort_a_Linked_List Sort = new Sort_a_Linked_List();
        Node list = new Node(1);
        list.next = new Node(3);
        list.next.next = new Node(2);
        list.next.next.next = new Node(4);
        list = sort(list);
        while (list != null) {
            System.out.print(list.data + " --> ");
            list = list.next;
        }
        System.out.println("null");
    }
}
