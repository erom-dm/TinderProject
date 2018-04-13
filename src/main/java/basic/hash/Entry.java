package basic.hash;

public class Entry<K,V> {
    private final K key;
    private final V value;

    Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("key:%s, value:%s",key,value);
    }
}
