package basic.hash;

import java.util.ArrayList;
import java.util.List;

public class Hash {
    private int capacity=10;
    private List<List<String>> values;
    private List<List<Integer>> keys;

    public Hash() {
        keys = new ArrayList<>();
        values = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            keys.add(new ArrayList<>());
            values.add(new ArrayList<>());
        }
    }

    public void put(int key, String value) {
        int index = hash(key);
        keys.get(index).add(key);
        values.get(index).add(value);
    }

    public String get(int key) {
        int index = hash(key);
        List<Integer> row = keys.get(index);
        int indexRow = row.indexOf(key);
        String s = values.get(index).get(indexRow);
        return s;
    }

    private int hash(int key) {
        return key % capacity;
    }
}
