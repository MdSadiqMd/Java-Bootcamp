public class Merge_Two_Sorted_Lists {
    static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }

    public Node mergeLists(Node l1, Node l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.data < l2.data) {
            l1.next = mergeLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeLists(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        Merge_Two_Sorted_Lists merger = new Merge_Two_Sorted_Lists();

        Node l1 = new Node(1);
        l1.next = new Node(3);
        l1.next.next = new Node(5);

        Node l2 = new Node(2);
        l2.next = new Node(4);
        l2.next.next = new Node(6);

        Node mergedList = merger.mergeLists(l1, l2);
        while (mergedList != null) {
            System.out.print(mergedList.data + " -> ");
            mergedList = mergedList.next;
        }
        System.out.print("null");
    }
}
