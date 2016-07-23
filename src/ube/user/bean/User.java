package ube.user.bean;

public class User {
    private String username;

    private String password;

    private String general;

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

    public String getGeneral() {
        return this.general;
    }

    public void setGeneral(String general) {
        this.general = general;
    }

    public User() {
        this("1234546", "123456a", "ÄÐ");
    }

    private User(String username, String password, String gene) {
        this.username = username;
        this.password = password;
        this.general = gene;
    }
}
