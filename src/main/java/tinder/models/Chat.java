package tinder.models;

import java.util.UUID;
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
        msg.setMessageId(this.generateMessageId());
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
    
    /*public int generateChatId(int userId1, int userId2){
        UUID idOne = UUID.randomUUID();
        System.out.println(String.valueOf(idOne));
        TODO: generate unique chat ID based on user IDs (or time).   
    }*/

}
