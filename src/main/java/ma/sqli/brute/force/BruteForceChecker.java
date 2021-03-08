package ma.sqli.brute.force;

public class BruteForceChecker {





    public String login(User user){

        if(Data.users.get(user.getName()).equals(user.getPassword())){
            user.setEssays(0);
            return "Welcome " + user.getName() + "!";
        }

        else{
            if(user.getEssays() == 2)
                return "Multiple erroneous credentials, your account is locked.";
            user.setEssays(user.getEssays()+1);
            System.out.println(user.getEssays());
            return "User or password are incorrect.";
        }
    }

}
