package ma.sqli.brute.force;

public class User {
    String username;
    String password;
    String message;

    public User(String username, String password){
        this.username = username;
        this.password = password;
        this.message = "";
    }

    public String getName() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public void addMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.getMessage();
    }

    public void setMessage(String message){
        this.message = message;
    }
}
