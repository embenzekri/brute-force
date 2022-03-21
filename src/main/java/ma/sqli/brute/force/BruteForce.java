package ma.sqli.brute.force;

public interface BruteForce {
     String login(String username, String password);

     void addUser(String username, String password);

     String loginWithAndroid(String username, String password) ;

     void blacklist(String sqli);
}
