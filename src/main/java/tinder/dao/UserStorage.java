package tinder.dao;

import tinder.dao.InterfaceDAO;

import tinder.models.User;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserStorage implements InterfaceDAO<User>, Iterable<User> {
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
    public User get(int pk) {
        return this.data.get(pk);
    }

    @Override
    public void save(User user) {
        this.data.add(user);
    }

    @Override
    public void update(User object){
        for(User u:this.data){
            if(u.getUserId() == object.getUserId()){
                this.data.remove(u);
                this.data.add(object);
            }
        }
    }

    @Override
    public void delete(int pk) {

    }

    public int size(){
        return this.data.size();
    }

    public User getFirstUnseen(){
        for (User user:data) {
            if(user.isSeen()){
                continue;
            }
            else{
                return user;
            }
        }
        return null;
    }

}
