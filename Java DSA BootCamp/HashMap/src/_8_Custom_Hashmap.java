import java.util.*;
// Here we create an array to store values and a hash function which will convert the Inserting value into index of a particular array which we call it as bucket index (bi)
// As the Conflicts arises we can have same hashcode for two different Inserting values, so we store them in the same bucket in the form of Linked List
// As the Linked Lists will also form a sequence we assign Data Index (di) for the nodes of the linked List
// If all the Index of the First array is filled then we create a new Array of double the size of the Existing array and again apply hashing algorithm on the new array and ***re-arrange all the elements again as the hashing algorithm we made of dependent on the size of the array
public class _8_Custom_Hashmap { // This Hashmap is achieved by visualising it as Array of Linked Lists
    static class HashMap<K,V> { // Here the K,V are taken in the context of generics (Making our own Data type)
        private class Node {
            K key;
            V value;
            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }
        private int n; // n - nodes
        private int N; // N - buckets.length --> Each Linked List in the Node of an array is termed as bucket the length of the linked list in each bucket is N
        private LinkedList<Node>[] buckets; // Linked List at a particular Node
        @SuppressWarnings("unchecked") // This suppresses the warnings in the Hashmap class which are raised by compiler
        // Creating the Initial Hashmap Array
        public HashMap() {
            this.N = 4; // Initialising the length of array (hard coding)
            this.buckets = new LinkedList[4];
            for(int i=0; i<4; i++) {
                this.buckets[i] = new LinkedList<>(); // creating a linked list which stores ***"null" at every location
            }
        }

        // The Hash Function will return the Index in which the value that had inserted in hashmap need to be stored
        private int hashFunction(K key) {
            int bi = key.hashCode();
            return Math.abs(bi) % N; // We the absolute value to handle potential negative hash codes. We divide it by N (length of bucket) to Minimize it to the length of Array we have taken
        }

        private int searchInLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];
            for(int i=0; i<ll.size(); i++) {
                if(ll.get(i).key == key) {
                    return i;
                }
            }
            return -1;
        }

        // We double the size of the array if the array we have taken is filled but inserting the elements
        @SuppressWarnings("unchecked")
        private void rehash() {
            LinkedList<Node>[] oldBucket = buckets;
            buckets = new LinkedList[N*2];
            for(int i=0; i<N*2; i++) {
                buckets[i] = new LinkedList<>();
            }
            for (LinkedList<Node> newBucket : oldBucket) { // Inserting the old Bucket items into new Bucket Linked List Items
                for (Node node : newBucket) { // Inserting Node values (Series of LL) into newBucket Nodes
                    put(node.key, node.value);
                }
            }
            /*
            for(int i=0; i<oldBucket.length; i++) {
                LinkedList<Node> ll = oldBucket[i];
                for(int j=0; j<ll.size(); j++) {
                    Node node = ll.get(j);
                    put(node.key, node.value);
                }
            }
             */
        }

        public void put(K key, V value) {
            // Calculate the bucket index using a hash function
            int bi = hashFunction(key);
            // Search for the key in the linked list at the calculated bucket index
            int di = searchInLL(key, bi);
            // If the key doesn't exist in the linked list
            if (di == -1) {
                // Add a new node with the key-value pair to the linked list at the bucket index
                buckets[bi].add(new Node(key, value));
                // Increment the total number of key-value pairs in the hash table
                n++;
            } else { // If the key already exists in the linked list
                // Update the value associated with the existing key
                Node node = buckets[bi].get(di);
                node.value = value;
            }
            // Calculate the load factor (lambda) of the hash table
            double lambda = (double) n / N;
            // If the load factor exceeds 2.0, trigger a rehash operation to resize the hash table
            if (lambda > 2.0) {
                rehash();
            }
        }

        public boolean containsKey(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            return di!=-1; // return true if key contains in the hash table and false if the key not present in hash table
            /*
            if(di == -1) { //key doesn't exist
                return false;
            } else { //key exists
                return true;
            }
             */
        }

        public V remove(K key) { // It returns the V (value type in Node)
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            if(di == -1) { // key doesn't exist
                return null;
            } else { // key exists
                Node node = buckets[bi].remove(di); // Here we are not using the remove method of a Java HashMap. Instead, it is using the remove method of a linked list
                n--;
                return node.value;
            }
        }

        public V get(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            if(di == -1) { // key doesn't exist
                return null;
            } else { // key exists
                Node node = buckets[bi].get(di); // ***The get method of the LinkedList class, not the HashMap
                return node.value;
            }
        }

        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();
            for (LinkedList<Node> ll : buckets) { // Iterate over Linked lists in all the Nodes
                for (Node node : ll) { // Iterate Over each linked List in particular node and store the node value in the key
                    keys.add(node.key); // add the key in arrayList that to be returned as answer
                }
            }
            /*
            for(int i=0; i<buckets.length; i++) { //bi
                LinkedList<Node> ll = buckets[i];
                for(int j=0; j<ll.size(); j++) { //di
                    Node node = ll.get(j);
                    keys.add(node.key);
                }
            }
             */
            return keys;
        }

        public boolean isEmpty() {
            return n == 0; // Returns true if the Hashmap is empty or false if Hashmap is full
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>(); // Using our custom Hashmap
        map.put("India", 190);
        map.put("China", 200);
        map.put("US", 50);
        ArrayList<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println(key + " " + map.get(key));
        }
        /*
        for(int i=0; i<keys.size(); i++) {
            System.out.println(keys.get(i)+" "+map.get(keys.get(i)));
        }
         */
        map.remove("India");
        System.out.println(map.get("India"));
    }
}
