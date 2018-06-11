package webserver;

import java.util.HashMap;

public class DatabaseHashMap implements Database {
    private final HashMap<Integer, String> data = new HashMap<>();

    @Override
    public void put(int key, String value) {
        data.put(key, value);
    }

    @Override
    public String get(int key) {
        return data.get(key);
    }
}
