package basic.hash;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Hash<K,V> implements Iterable<Entry<K,V>>{
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
        List<K> kl = keys.get(index);
        int index2 = kl.indexOf(key);
        if (index2 == -1) { // no key, clean insert
            kl.add(key);
            values.get(index).add(value);
        } else { // key present, just update update
            values.get(index).set(index2, value);
        }
    }

    public V get(K key) {
        int index = hash(key);

        int indexRow = keys.get(index).indexOf(key);
        return indexRow!=-1 ?
                values.get(index).get(indexRow) : null;
    }

    public boolean containsKey(K key){
        return keys.get(hash(key)).indexOf(key) != -1;
    }

    public void remove(K key){
        int hash = hash(key);
        List kl = keys.get(hash);
        if (kl.indexOf(key) != -1) {
            int index = kl.indexOf(key);
            kl.remove(index);
            values.get(hash).remove(index);
        }
    }

    private int hash(K key) {
        return key.hashCode() % capacity;
    }

    @Override
    public Iterator<Entry<K, V>> iterator() {
        return new Iterator<Entry<K, V>>() {
            private Iterator<List<K>> itL = keys.iterator();
            private Iterator<K> itK = itL.next().iterator();

            private void shiftIndex() {
                while (itL.hasNext() && !itK.hasNext()) {
                    itK = itL.next().iterator();
                }
            }

            @Override
            public boolean hasNext() {
                return itL.hasNext() || itK.hasNext();
            }

            @Override
            public Entry<K, V> next() {
                K key =itK.next();
                shiftIndex();
                return new Entry<>(key, get(key));
            }
        };
    }
}
