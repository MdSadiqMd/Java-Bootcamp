import java.util.HashMap;
import java.util.Map;

public class LFU_Cache {
    final int capacity;
    int curSize;
    int minFrequency;
    Map<Integer, DLLNode> cache;
    Map<Integer, DoubleLinkedList> frequencyMap;

    static class DLLNode {
        int key, value, frequency;
        DLLNode prev, next;

        public DLLNode(int key, int value) {
            this.key = key;
            this.value = value;
            this.frequency = 1;
        }
    }

    static class DoubleLinkedList {
        DLLNode head, tail;
        int size;

        public DoubleLinkedList() {
            head = new DLLNode(0, 0);
            tail = new DLLNode(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        // Add a node to the head of the linked list
        public void addToHead(DLLNode node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }

        // Remove a node from the linked list
        public void removeNode(DLLNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        // Check if the linked list is empty
        public boolean isEmpty() {
            return size == 0;
        }
    }

    public LFU_Cache(int capacity) {
        this.capacity = capacity;
        this.curSize = 0;
        this.minFrequency = 0;
        this.cache = new HashMap<>();
        this.frequencyMap = new HashMap<>();
    }

    public int get(int key) {
        DLLNode curNode = cache.get(key);
        if (curNode == null) {
            return -1;
        }
        updateNode(curNode);
        return curNode.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }

        // If key exists, update the value and increase the frequency
        if (cache.containsKey(key)) {
            DLLNode curNode = cache.get(key);
            curNode.value = value;
            updateNode(curNode);
        } else {
            // If the cache is full, remove the least frequently used element
            if (curSize == capacity) {
                evictNode();
            }

            // Add the new node with frequency 1
            DLLNode newNode = new DLLNode(key, value);
            cache.put(key, newNode);
            addToFrequencyList(newNode);

            // Reset minFrequency since we added a new node
            minFrequency = 1;
            curSize++;
        }
    }

    private void updateNode(DLLNode node) {
        // Remove the node from its current frequency list
        DoubleLinkedList curList = frequencyMap.get(node.frequency);
        curList.removeNode(node);

        // If the current list is empty and its frequency is the minFrequency, update minFrequency
        if (curList.isEmpty() && node.frequency == minFrequency) {
            minFrequency++;
        }

        // Increase the frequency of the node and add it to the new frequency list
        node.frequency++;
        addToFrequencyList(node);
    }

    private void addToFrequencyList(DLLNode node) {
        // Get the list for the current frequency, or create a new list if it doesn't exist
        DoubleLinkedList curList = frequencyMap.getOrDefault(node.frequency, new DoubleLinkedList());
        curList.addToHead(node);
        frequencyMap.put(node.frequency, curList);
    }

    private void evictNode() {
        // Get the list with the minimum frequency
        DoubleLinkedList minFrequencyList = frequencyMap.get(minFrequency);

        // Get the least frequently used node from the list
        DLLNode evictedNode = minFrequencyList.tail.prev;

        // Remove the node from the list and the cache
        minFrequencyList.removeNode(evictedNode);
        cache.remove(evictedNode.key);

        // If the list becomes empty, update minFrequency
        if (minFrequencyList.isEmpty()) {
            frequencyMap.remove(minFrequency);
        }

        // Reset minFrequency since we removed a node
        minFrequency = 1;
        curSize--;
    }

    public class LFUCacheTest {

        public static void main(String[] args) {
            // Create an LFU Cache with a capacity of 3
            LFU_Cache cache = new LFU_Cache(3);

            // Test Case 1: Basic put and get operations
            cache.put(1, 1);
            cache.put(2, 2);
            System.out.println(cache.get(1)); // Expected output: 1
            System.out.println(cache.get(2)); // Expected output: 2
            System.out.println(cache.get(3)); // Expected output: -1 (not found)

            // Test Case 2: Eviction due to capacity limit
            cache.put(3, 3);
            cache.put(4, 4); // Evicts key 1, as it is the least frequently used
            System.out.println(cache.get(1)); // Expected output: -1 (not found)
            System.out.println(cache.get(3)); // Expected output: 3
            System.out.println(cache.get(4)); // Expected output: 4

            // Test Case 3: Update frequency on get
            cache.get(3); // Frequency of key 3 becomes 2
            cache.put(5, 5); // Evicts key 2, as it is the least frequently used
            System.out.println(cache.get(2)); // Expected output: -1 (not found)
            System.out.println(cache.get(3)); // Expected output: 3
            System.out.println(cache.get(5)); // Expected output: 5
        }
    }
}
