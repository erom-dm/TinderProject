package tinder.dao;


public interface InterfaceDAO<T> {
    T get(int pk);
    void save(T object);
    void update(T object);
    void delete(int pk);
}
