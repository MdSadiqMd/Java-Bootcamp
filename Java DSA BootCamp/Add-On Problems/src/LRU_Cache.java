import java.util.HashMap;
import java.util.Map;

public class LRU_Cache { // Least Recently Used Cache
    static class Node{
        Node prev, next;
        int key, value;
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    Node head = new Node(0, 0), tail = new Node(0, 0); // Initialize the head and tail addresses of the double-linked list to zero
    Map<Integer, Node> map = new HashMap<>(); // Map to store the key-value pairs with keys pointing to corresponding nodes
    int capacity; // Maximum capacity of the cache
    public LRU_Cache(int capacity){ // Constructor to initialize the LRU Cache with a given capacity
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    public int get(int key){
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        } else {
            return -1; // Key not present in the cache
        }
    }
    public void put(int key, int value){
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        if(map.size() == capacity){
            remove(tail.prev); // Remove the least recently used node (at the end of the list)
        }
        insert(new Node(key, value)); // Insert the new node at the beginning of the list
    }
    public void remove(Node node){
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    public void insert(Node node){ // Insert a node at the beginning of the linked list and update the map
        map.put(node.key, node);
        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        headNext.prev = node;
        node.next = headNext;
    }

    public static void main(String[] args) {
        LRU_Cache cache = new LRU_Cache(2); // Creating an LRU Cache with capacity 2
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); // Expected output: 1
        cache.put(3, 3); // Removes key 2 as it exceed the capacity limit
        System.out.println(cache.get(2)); // Expected output: -1 (not found)
        cache.put(4, 4); // Removes key 1
        System.out.println(cache.get(1)); // Expected output: -1 (not found)
        System.out.println(cache.get(3)); // Expected output: 3
        System.out.println(cache.get(4)); // Expected output: 4
    }

}
