package ma.sqli.brute.force;

/**
 * @author : El Mahdi Benzekri
 * @since : 3/7/21, dim.
 **/
public class BruteForceApp {
    ListUsers users = new ListUsers();
    public static int tries = 0;
    public static int androidTries = 0;

    public String login(String username, String password) {
        //get the user from the list
        User user = users.getUser(new User(username, password));

        if( user != null ){
            if(user.isBlackList()){
                return "Your account is blacklisted, contact the CRC to resolve the problem.";
            }else{
                //reset number of tries
                tries = 0;
//                String message = user.getMessage();
//                if(message.equals("")){
//                    return message;
//                }
                return "Welcome " + user.getName() + "!";
            }

        } else if(tries > 1) {
            return lock();
        }
        else {
            tries++;
            return "User or password are incorrect.";

        }

    }

    public void addUser(String username, String password) {
        User user = new User(username, password);
        if(password.length() < 2){
            user.setMessage("Your password is too weak, please update it by going to your my account.");
        }else{
            user.setMessage("");
        }

        this.users.addUser(user);
    }

    public boolean blacklist(String username){
        User user = this.users.getUserByUsername(username);
        if( user != null ){
            user.setBlackList(true);
            return true;
        }
        return false;
    }

    public String lock(){
            return "Multiple erroneous credentials, your account is locked.";
    }

    public String loginWithAndroid(String username, String password) {
        User user = new User(username, password);
        users.getUser(user);

        if( users.getUser(user) != null ){
            //reset number of tries
            tries = 0;
            return "Welcome " + user.getName() + "!";
        } else if(androidTries > 1) {
            return lock();
        }
        else {
            tries++;
            return "User or password are incorrect.";

        }
    }
}
