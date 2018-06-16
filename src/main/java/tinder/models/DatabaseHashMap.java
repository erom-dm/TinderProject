package tinder.models;

import java.util.HashMap;

public class DatabaseHashMap implements Database{
    private final HashMap<Integer, Opinion> data = new HashMap<>();

    @Override
    public void put(int key, Opinion value) {
        data.put(key,value);
    }

    @Override
    public Opinion get(int key) {
        return data.get(key);
    }
}
