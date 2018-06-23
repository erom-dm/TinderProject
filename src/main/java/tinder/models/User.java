package tinder.models;

public class User {
    private int userId;
    private String userName;
    private String userPicURL;
    private String gender;
    private long lastLogin;
    private String email;
    private String password;

    public User() {
    }

    public User(String userName, String gender, String userPic){
        this.userName = userName;
        this.userPicURL = userPic;
        this.gender = gender;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPicURL() {
        return userPicURL;
    }

    public void setUserPicURL(String userPicURL) {
        this.userPicURL = userPicURL;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(long lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
