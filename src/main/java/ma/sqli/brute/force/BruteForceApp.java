package ma.sqli.brute.force;

/**
 * @author : El Mahdi Benzekri
 * @since : 3/7/21, dim.
 **/
public class BruteForceApp {
    public Login_Attempt login=new Login_Attempt();
    public String mssg;
    public int count;
    public String login(String username, String password) {
       if(login.Check(username,password)) {
           mssg = "Welcome admin!";
       }else{
           count++;
           mssg="User or password are incorrect.";
       }
       if(count >=1 ){
           mssg="Multiple erroneous credentials, your account is locked.";
       }
       return mssg;
    }

    public void addUser(String username, String password) {
      login.setAccounts(username, password);
    }

    public String loginWithAndroid(String username, String password) {
        return "";
    }

    public void blacklist(String sqli) {

    }
}
