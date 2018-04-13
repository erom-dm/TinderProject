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

    @Override
    public Iterator<Entry<K, V>> iterator() {
        return new IterEntry();
    }

    class IterEntry implements Iterator<Entry<K, V>> {
        private int mainIndex =0;
        private Iterator<K> itK;
        private Iterator<V> itV;

        IterEntry() {
            updateKeyIterator();
            updateValIterator();
        }

        private void updateKeyIterator() {
            itK = keys.get(mainIndex).iterator();
        }

        private void updateValIterator() {
            itV = values.get(mainIndex).iterator();
        }

        private void shiftIndex() {
            if (itK.hasNext()) return;

            while (++mainIndex < keys.size()) {
                updateKeyIterator();
                if (itK.hasNext()) {
                    updateValIterator();
                    break;
                }
            }
        }

        @Override
        public boolean hasNext() {
            return itK.hasNext() || mainIndex < keys.size();
        }

        @Override
        public Entry<K, V> next() {
            Entry e = new Entry<>(itK.next(), itV.next());
            shiftIndex();
            return e;
        }
    }
}
