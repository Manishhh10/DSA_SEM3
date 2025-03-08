package DSA_EXAM_QNS;
import java.util.HashMap;


public class QN_12 {

public class LFUCache {
    private int capacity;
    private int minFreq;
    private HashMap<Integer, Node> keyNode;
    private HashMap<Integer, DoublyLinkedList> freqMap;
    
    // Node represents an entry in the cache.
    private class Node {
        int key;
        int value;
        int freq;
        Node prev;
        Node next;
        
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1; // new node starts with frequency 1
        }
    }
    
    // DoublyLinkedList to hold nodes of the same frequency.
    private class DoublyLinkedList {
        Node head;
        Node tail;
        int size;
        
        public DoublyLinkedList() {
            // Using dummy head and tail nodes for simpler add and remove operations.
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }
        
        // Adds a node right after head.
        public void addNode(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }
        
        // Removes the given node from the list.
        public void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }
        
        // Removes the least recently used node (from the tail).
        public Node removeLast() {
            if (size > 0) {
                Node node = tail.prev;
                removeNode(node);
                return node;
            }
            return null;
        }
    }
    
    // Constructor for the LFUCache.
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.keyNode = new HashMap<>();
        this.freqMap = new HashMap<>();
    }
    
    // Retrieves the value for the given key if present; otherwise, returns -1.
    public int get(int key) {
        if (!keyNode.containsKey(key)) {
            return -1;
        }
        Node node = keyNode.get(key);
        updateNode(node);
        return node.value;
    }
    
    // Inserts or updates the value for the given key.
    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        
        // Key exists: update its value and frequency.
        if (keyNode.containsKey(key)) {
            Node node = keyNode.get(key);
            node.value = value;
            updateNode(node);
        } else {
            // If the cache is at capacity, remove the least frequently used node.
            if (keyNode.size() >= capacity) {
                DoublyLinkedList minFreqList = freqMap.get(minFreq);
                Node nodeToRemove = minFreqList.removeLast();
                keyNode.remove(nodeToRemove.key);
            }
            // Insert the new node.
            Node newNode = new Node(key, value);
            keyNode.put(key, newNode);
            // Add the node to the frequency list for frequency 1.
            DoublyLinkedList list = freqMap.getOrDefault(1, new DoublyLinkedList());
            list.addNode(newNode);
            freqMap.put(1, list);
            // Reset the min frequency to 1.
            minFreq = 1;
        }
    }
    
    // Updates a node's frequency and reassigns it to the appropriate list.
    private void updateNode(Node node) {
        int currFreq = node.freq;
        DoublyLinkedList currList = freqMap.get(currFreq);
        currList.removeNode(node);
        
        // If this list was the one with the minimum frequency and is now empty, increment minFreq.
        if (currFreq == minFreq && currList.size == 0) {
            minFreq++;
        }
        
        // Increase the node's frequency.
        node.freq++;
        // Add node to the new frequency list.
        DoublyLinkedList newList = freqMap.getOrDefault(node.freq, new DoublyLinkedList());
        newList.addNode(node);
        freqMap.put(node.freq, newList);
    }
    
    // Example usage
    public static void main(String[] args) {
        // LFUCache cache = new LFUCache(2);
        
        // cache.put(1, 1);   // cache=[1:_], freq(1)=1
        // cache.put(2, 2);   // cache=[1:_, 2:_], freq(1)=1, freq(2)=1
        // System.out.println(cache.get(1)); // returns 1, now freq(1)=2, freq(2)=1
        // cache.put(3, 3);   // evicts key 2, cache=[1:_, 3:_], freq(1)=2, freq(3)=1
        // System.out.println(cache.get(2)); // returns -1 (not found)
        // System.out.println(cache.get(3)); // returns 3, now freq(3)=2
        // cache.put(4, 4);   // evicts key 1 (as it is least frequently used), cache=[3:_, 4:_]
        // System.out.println(cache.get(1)); // returns -1 (not found)
        // System.out.println(cache.get(3)); // returns 3, now freq(3)=3
        // System.out.println(cache.get(4)); // returns 4, now freq(4)=2
    }
}

}
