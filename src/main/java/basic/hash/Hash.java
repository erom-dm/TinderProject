package basic.hash;

import java.util.ArrayList;
import java.util.List;

public class Hash {
    private int capacity=10;
    private List<ArrayList<String>> values;
    private List<ArrayList<Integer>> keys;

    public Hash() {
        values = new ArrayList<ArrayList<String>>(capacity);
        for (int i = 0; i < values.size(); i++) {
            values.add(new ArrayList<String>());
        }
        keys = new ArrayList<ArrayList<Integer>>(capacity);
        for (int i = 0; i < keys.size(); i++) {
            keys.add(new ArrayList<Integer>());
        }
    }

    public void put(int key, String value) {
        int index = hash(key);
        keys.get(index).add(key);
        values.get(index).add(value);
    }

    public String get(int key) {
        int index = hash(key);
        ArrayList<Integer> row = keys.get(index);
        int indexRow = row.indexOf(key);
        String s = values.get(index).get(indexRow);
        return s;
    }

    private int hash(int key) {
        return key % capacity;
    }
}
