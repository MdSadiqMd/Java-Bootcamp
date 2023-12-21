import java.util.*;
/*
Here we take a MinHeap using priority Queue and keep all elements into it and pop the elements as they are in ascending order and keep them in the form of Linked List
We take a Dummy Node to traverse after it and return the dummy Node "next" and traverse over it to print solution
 */
public class Merge_K_Sorted_Lists {
    static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    public static Node merge(List<Node> ans){
        if(ans.isEmpty()){
            return null;
        }
        PriorityQueue<Node> minheap = new PriorityQueue<Node>((a,b) -> a.data - b.data);
        for(Node list:ans){
            if(list!=null){
                minheap.offer(list);
            }
        }
        Node dummy=new Node(0);
        Node current=dummy;
        while(!minheap.isEmpty()){
            Node smallest=minheap.poll();
            current.next=smallest;
            current=current.next;
            if(smallest.next!=null){
                minheap.offer(smallest.next);
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        List<Node> lists = new ArrayList<>();

        Node list1 = new Node(1);
        list1.next = new Node(4);
        list1.next.next = new Node(5);

        Node list2 = new Node(1);
        list2.next = new Node(3);
        list2.next.next = new Node(4);

        Node list3 = new Node(2);
        list3.next = new Node(6);

        lists.add(list1);
        lists.add(list2);
        lists.add(list3);

        Node mergedList = merge(lists);

        while (mergedList != null) {
            System.out.print(mergedList.data + " -> ");
            mergedList = mergedList.next;
        }
        System.out.print("null");
    }
}
