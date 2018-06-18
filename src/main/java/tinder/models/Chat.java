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
    
    //public void setData(Message message) {
     //   this.data.add(message);
    //}
    
    public void addMessage(Message msg){
        //msg.setMessageId(idGenerator());
        this.data.add(msg);
    }
    
    public int generateMessageId(){
        int id;
        for(Message msg:this.data){
            id = msg.getMessageId();
        }
        if (id == null){
            id = 0;
            return id;
        }
        return id++;
    }

}
