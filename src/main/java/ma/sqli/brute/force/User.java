package ma.sqli.brute.force;

public class User {
    String username;
    String password;
    String message;
    boolean blackList;

    public User(String username, String password){
        this.username = username;
        this.password = password;
        this.message = "";
        this.blackList = false;
    }

    public String getName() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.getMessage();
    }

    public void setBlackList(boolean blackList) {
        this.blackList = blackList;
    }

    public boolean isBlackList() {
        return blackList;
    }
}
