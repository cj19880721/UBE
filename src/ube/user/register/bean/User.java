package ube.user.register.bean;

public class User {
    private String username;

    private String password;

    private String gender;

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public User() {
        this("1234546", "123456a", "ÄÐ");
    }

    private User(String username, String password, String gender) {
        this.username = username;
        this.password = password;
        this.gender = gender;
    }
}
