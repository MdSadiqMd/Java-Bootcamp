import java.util.HashMap;
import java.util.Map;

public class LRU_Cache {
    static class Node{
        Node prev,next;
        int key,value;
        Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }

    Node head= new Node(0, 0),tail= new Node(0, 0); //
    Map<Integer,Node> map=new HashMap<>();
    int capacity;

    public void LRUCache(int capacity){
        this.capacity=capacity;
        head.next=tail;
        tail.prev=head;
    }

    public int get(int key){
        if(map.containsKey(key)){
            Node node=map.get(key);
            remove(node);
            insert(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key,int value){
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        if(map.size()==capacity){
            remove(tail.prev);
        }
        insert(new Node(key, value));
    }

    public void remove(Node node){
        map.remove(node.key);
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }

    public void insert(Node node){
        map.put(node.key,node);
        Node headNext=head.next;
        head.next=node;
        node.prev=head;
        headNext.prev=node;
        node.next=headNext;
    }

    public static void main(String[] args) {

    }
}
