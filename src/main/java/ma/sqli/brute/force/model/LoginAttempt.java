package ma.sqli.brute.force.model;


public class LoginAttempt extends User{
    
    private int nbLoginAttempt =0;
    private int nbAndroidLoginAttempt =0;

    public LoginAttempt(User user) {
        super(user.getUsername(), user.getPassword());
    }

    public int getNbLoginAttempt(){
        return  nbLoginAttempt;
    }
    public int getNbAndroidLoginAttempt(){return nbAndroidLoginAttempt;}
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
}
