package tinder.models;

import java.util.Date;

public class Message {
     private int userId1;
     private int userId2;
     private String text;
     private long time;

    public  Message(){ }

    public Message(int userId1, int userId2, String text){

        java.util.Date date = new Date();

        this.userId1 = userId1;
        this.userId2 = userId2;
        this.text = text;
        this.time = date.getTime();
    }

    public int getUserId1() {
        return userId1;
    }

    public void setUserId1(int userId1) {
        this.userId1 = userId1;
    }

    public int getUserId2() {
        return userId2;
    }

    public void setUserId2(int userId2) {
        this.userId2 = userId2;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
