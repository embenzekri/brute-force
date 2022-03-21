package ma.sqli.brute.force.model;


public class LoginAttempt extends User{
    private final int NB_LOGIN_ATTEMPT = 2;
    private int nbLoginAttempt =0;
    private int nbAndroidLoginAttempt =0;

    public LoginAttempt(User user) {
        super(user.getUsername(), user.getPassword());
    }

    public void increaseNbLoginAttempt(){
        nbLoginAttempt++;
    }
    public void resetNbLoginAttempt(){
        nbLoginAttempt=0;
    }
    public void increaseNbAndroidLoginAttempt(){
        nbAndroidLoginAttempt++;
    }
    public void resetNbAndroidLoginAttempt(){
        nbAndroidLoginAttempt=0;
    }
    public boolean isNbLoginAttemptreached() {
        if (nbLoginAttempt >= NB_LOGIN_ATTEMPT) {
            return true;
        }
        return false;
    }
    public boolean isNbLoginAndroidAttemptreached(){
        if (nbAndroidLoginAttempt>=NB_LOGIN_ATTEMPT){
            return true;
        }
        return false;
    }
}
