import java.util.*;

public class Merge_K_Sorted_Lists {
    static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    public static Node merge(List<Node> ans,int k){
        if(ans.size()==0 || ans.isEmpty()){
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
        Node smallest=dummy.next;
        while(!minheap.isEmpty()){
            current.next=smallest;
            current=current.next;
            if(current.next==null){

            }
        }
        return null;
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

        Node mergedList = merge(lists,k);

        while (mergedList != null) {
            System.out.print(mergedList.data + " -> ");
            mergedList = mergedList.next;
        }
    }
}
