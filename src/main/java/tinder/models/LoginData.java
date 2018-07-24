package tinder.models;

public class LoginData {
    private boolean passwordMatch;
    private int id;
    private String gender;

    public boolean isPasswordMatch() {
        return passwordMatch;
    }

    public void setPasswordMatch(boolean passwordMatch) {
        this.passwordMatch = passwordMatch;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}
