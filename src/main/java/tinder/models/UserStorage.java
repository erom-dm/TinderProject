package tinder.models;

import java.util.ArrayList;
import java.util.List;

public class UserStorage implements Storage {
    private final List<User> data = new ArrayList<>();

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
