package tinder.models;

import java.util.ArrayList;
import java.util.List;

public class Chat {
    private int chatID;
    private List<Message> data = new ArrayList<>();

    public int getChatID() {
        return chatID;
    }

    public void setChatID(int chatID) {
        this.chatID = chatID;
    }
    
    //public List<Message> getData() {
        //return data;
    //}
    
    //public void setChatID(Message message) {
     //   this.data.add(message);
    //}

}
