package ma.sqli.brute.force;

public class BruteForce {
    private int attempt;
    private String admin;
    private String password;

    public BruteForce(String admin, String password) {
        this.attempt = 0;
        this.admin = admin;
        this.password = password;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAttempt() {
        return attempt;
    }

    public void setAttempt(int attempt) {
        this.attempt = attempt;
    }
}
