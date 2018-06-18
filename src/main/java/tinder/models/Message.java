package tinder.models;

public class Message {
     private int userId;
     private int messageId;
     private String text;
     private String time;
     
    public Message(int userId, String text, String time){
         this.userId = userId;
         this.text = text;
         this.time = time;
    }
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
