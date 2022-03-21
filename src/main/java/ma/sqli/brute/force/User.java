package ma.sqli.brute.force;

public class User {
    private final String username;
    private final String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean equals(User obj) {
        return this.username.equals(obj.username) && this.password.equals(obj.password);
    }
}
