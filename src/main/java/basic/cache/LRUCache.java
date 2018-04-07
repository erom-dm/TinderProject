package basic.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LRUCache<K,V> {

    private class Node {
        K key;
        V value;
        Node prev = null, next = null;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private int size = 0;
    Node least;
    Node most;

    Map<K,Node> cach = new HashMap<>();

    public LRUCache(int capacity){
        this.capacity = capacity;
    }

    public LRUCache(){
        this.capacity = 100;
    }

    public void put(K key, V value){
        if (cach.containsKey(key)) {
            return;
        }

        Node node = new Node(key,value);
        cach.put(key, node);

        if (size == 0) {
            least = node;
            most = node;
            size++;
            return;
        }

        node.prev = most;
        most.next = node;
        most = node;

        if (size == capacity) {
            cach.remove(least.key);
            least = least.next;
            least.prev = null;
        }
        else {
            size++;
        }
    }

    public V get(K key){
        if (!cach.containsKey(key)) {
            return null;
        }

        Node node = cach.get(key);

        if (node == most) {
            return node.value;
        }

        Node prevNode = node.prev;
        Node nextNode = node.next;

        node.prev = most;
        most.next = node;
        most = node;
        most.next = null;

        if (node == least) {
            nextNode.prev = null;
            least = nextNode;
        } else {
            prevNode.next =  nextNode;
            nextNode.prev = prevNode;
        }

        return node.value;
    }
}
