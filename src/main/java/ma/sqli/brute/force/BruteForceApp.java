package ma.sqli.brute.force;

/**
 * @author : El Mahdi Benzekri
 * @since : 3/7/21, dim.
 **/
public class BruteForceApp {

    public String login(String username, String password) {

        Login log= new Login(username, password);

            if(log!=null){
                if((log.getUsername().equals("admin") && log.getPassword().equals("123")) ||
                    log.getUsername().equals("sqli") && log.getPassword().equals("0000") )
                {

                      if(log.getUsername().equals("admin"))
                       {
                        return "Welcome admin!";
                       }
                    else{
                        return "Welcome sqli!";
                        }
                }
                else{
                    return "User or password are incorrect.";
                }
            }
            else return "";




    }

    public void addUser(String username, String password) {

    }

    public String loginWithAndroid(String username, String password) {
        return "Welcome Admin"+username;
    }

    public void blacklist(String sqli) {

    }
}
