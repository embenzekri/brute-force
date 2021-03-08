package ma.sqli.brute.force;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class SecureLogin {

    private HashMap<String, Integer> loginAttempt= new HashMap<>();
    private UserRepo userRepo =  UserRepo.getInstance();

    private static SecureLogin single_instance = null;

    public static SecureLogin getInstance()
    {
        if (single_instance == null)
            single_instance = new SecureLogin();

        return single_instance;
    }

    public  String login(String admin, String password) {

        List CurrentUser = userRepo.findUserByNameAndPassword(admin, password);
        if(CurrentUser.isEmpty())
            return checkBruteForce(admin);
        else
            return successfulLogin(admin);
    }


    public String checkBruteForce(String admin) {
        loginAttempt.put(admin, loginAttempt.get(admin) + 1 );
        if(loginAttempt.get(admin) >= 3){
            return errorMessage.bruteForceMessage;
        }
        else {
            return errorMessage.incorrectCredential;
        }
    }

    public String successfulLogin(String admin) {
        loginAttempt.put(admin, 0);
        return "Welcome " + admin + "!";
    }

    public void signup(String admin, String password){
        userRepo.addUser(admin, password);
        loginAttempt.put(admin, 0);
    }
}
