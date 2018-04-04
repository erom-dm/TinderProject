package basic.hash;

import java.util.ArrayList;
import java.util.List;

public class Hash<K,V> {
    private int capacity=10;
    private List<List<K>> keys = new ArrayList<>();;
    private List<List<V>> values = new ArrayList<>();;

    public Hash() {
        for (int i = 0; i < capacity; i++) {
            keys.add(new ArrayList<>());
            values.add(new ArrayList<>());
        }
    }

    public void put(K key, V value) {
        int index = hash(key);

        keys.get(index).add(key);
        values.get(index).add(value);
    }

    public V get(K key) {
        int index = hash(key);

        int indexRow = keys.get(index).indexOf(key);
        return indexRow!=-1 ?
                values.get(index).get(indexRow) : null;
    }

    private int hash(K key) {
        return key.hashCode() % capacity;
    }
}
