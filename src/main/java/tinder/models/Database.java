package tinder.models;

public interface Database {
    void put(int k, Opinion v);
    Opinion get(int k);
}
