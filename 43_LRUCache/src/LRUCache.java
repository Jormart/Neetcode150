import java.util.*;

class LRUCache {

    // Define a Node class to store the key and value of the cache
    private static class Node {
        int key;
        int value;
        Node prev;
        Node next;
        // Define a constructor to initialize the Node
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // Define a HashMap to store the key and the corresponding Node
    private Map<Integer, Node> map;
    // Define a dummy head and tail Node
    private Node head; // Most recently used
    private Node tail; // Least recently used
    // Define the capacity of the cache
    private int capacity;

    public LRUCache(int capacity) {
        // Initialize the HashMap
        map = new HashMap<>();
        // Initialize the dummy head and tail Node
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        // Connect the head and tail Node
        head.next = tail;
        tail.prev = head;
        // Initialize the capacity
        this.capacity = capacity;
    }

    public int get(int key) {
        // If the key does not exist in the cache, return -1
        if (!map.containsKey(key)) {
            return -1;
        }
        // Get the Node from the HashMap
        Node node = map.get(key);
        // Remove the Node from the LinkedList
        remove(node);
        // Add the Node to the head of the LinkedList
        add(node);
        // Return the value of the Node
        return node.value;
    }
    
    public void put(int key, int value) {
        // Check if the key exists in the cache
        if (map.containsKey(key)) {
            // Get the Node from the HashMap
            Node node = map.get(key);
            // Update the value of the Node
            node.value = value;
            // Remove the Node from the LinkedList
            remove(node);
            // Add the Node to the head of the LinkedList
            add(node);
        } else {
            // Check if the cache is full
            if (map.size() == capacity) {
                // Remove the least recently used Node from the LinkedList
                map.remove(tail.prev.key);
                remove(tail.prev);
            }
            // Create a new Node with the key and value
            Node node = new Node(key, value);
            // Add the Node to the HashMap
            map.put(key, node);
            // Add the Node to the head of the LinkedList
            add(node);
        }
    }

    // Define a helper method to remove a Node from the LinkedList
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Define a helper method to add a Node to the head of the LinkedList
    private void add(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public static void main(String[] args) {
        // Create a new LRUCache with capacity 2
        LRUCache cache = new LRUCache(2);
        // Put (1, 1) in the cache
        cache.put(1, 1);
        // Put (2, 2) in the cache
        cache.put(2, 2);
        // Get the value of key 1
        System.out.println(cache.get(1)); // Output: 1
        // Put (3, 3) in the cache
        cache.put(3, 3);
        // Get the value of key 2
        System.out.println(cache.get(2)); // Output: -1
        // Put (4, 4) in the cache
        cache.put(4, 4);
        // Get the value of key 1
        System.out.println(cache.get(1)); // Output: -1
        // Get the value of key 3
        System.out.println(cache.get(3)); // Output: 3
        // Get the value of key 4
        System.out.println(cache.get(4)); // Output: 4
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */