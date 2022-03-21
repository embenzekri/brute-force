package ma.sqli.brute.force.Model;

import ma.sqli.brute.force.Storage.UserStorage;

public class Login {
    private String name;
    private String password;
    private boolean isBlocked;
    private int counter;
    private final UserStorage userStorage;


    public Login(String name, String password,UserStorage userStorage) {
        this.name = name;
        this.password = password;
        this.isBlocked = false;
        this.userStorage = userStorage;
        counter=0;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }
    public String login(){
        if(isBlocked() ||counter==3){
            isBlocked=true;
            return  "Multiple erroneous credentials, your account is locked.";
        }
        else {
            User user=this.userStorage.loadUser(name);
            if(user==null || user.getPassword()!=password) return "User or password are incorrect.";
            if(user.getName().equals("admin")) return "Welcome admin!";
            return "Welcome !";
        }


    }
}
