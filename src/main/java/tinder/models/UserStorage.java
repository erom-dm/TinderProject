package tinder.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserStorage implements Storage, Iterable<User> {
    private final List<User> data = new ArrayList<>();

    @Override
    public Iterator<User> iterator() {
        Iterator<User> it = new Iterator<User>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < data.size() && data.get(currentIndex) != null;
            }

            @Override
            public User next() {
                return data.get(currentIndex++);
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }

    @Override
    public void put(User user) {
        this.data.add(user);
    }

    @Override
    public User get(int userId) {
        return this.data.get(userId);
    }

    @Override
    public int size(){
        return this.data.size();
    }

    @Override
    public User getFirstUnseen(){
        for (User user:data) {
            if(user.seen){
                continue;
            }
            else{
                return user;
            }
        }
        return null;
    }
}
