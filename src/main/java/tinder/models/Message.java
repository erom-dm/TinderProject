package tinder.models;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Message {
     private int userId1;
     private int userId2;
     private String text;
     private String time;

    public  Message(){ }

    public Message(int userId1, int userId2, String text){

        this.userId1 = userId1;
        this.userId2 = userId2;
        this.text = text;
        this.time = getCurrentTimeDate();
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    private String getCurrentTimeDate() {
        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return sdf.format(dt);
    }
}
