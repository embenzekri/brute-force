package ma.sqli.brute.force;

import java.util.Objects;

public class User {
    private String name;
    private String password;
    private int attempt;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }


    public boolean equalsUserName(String username) {
        return this.name == username;
    }
    public boolean equalsPassword(String password) {
        return this.password == password;
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, password);
    }

    public int getAttempt() {
        return attempt;
    }

    public void setAttempt(int attempt) {
        this.attempt = attempt;
    }
}
