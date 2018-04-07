package basic.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LRUCache<K,V> {

    int capacity;
    Map<K,V> cach = new HashMap<>();

    public LRUCache(int capacity){
        this.capacity = capacity;
    }

    public LRUCache(){
        this.capacity = 100;
    }

    public void put(K key, V value){

        cach.put(key, value);

    }

    public V get(K key){

        return cach.get(key);
    }
}
