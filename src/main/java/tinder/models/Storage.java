package tinder.models;

public interface Storage {
    void put(User user);
    User get(int k);
    User getFirstUnseen();
    int size();
}
