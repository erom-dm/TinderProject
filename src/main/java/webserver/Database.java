package webserver;

public interface Database {
    void put(int k, String v);
    String get(int k);
}
