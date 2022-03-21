package ma.sqli.brute.force.Model;

public class User {
    private String name;
    private String password;
    private boolean isBlocked;

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


}
