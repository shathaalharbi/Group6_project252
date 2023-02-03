package project252_group6;

public class login implements Access {

    private String username;
    private String password;

    public login(String user, String password) {
        this.username = user;
        this.password = password;
    }

    public String getUser() {
        return username;
    }

    public void setUser(String user) {
        this.username = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public User checkaccess() {
        return null;
    }

}
