package ma.sqli.brute.force.validation;

import java.util.Map;

public class CredentialsValidator implements LoginValidator {
    private final Map<String, String> usernameAndPasswords;

    public CredentialsValidator(Map<String, String> usernameAndPasswords) {
        this.usernameAndPasswords = usernameAndPasswords;
    }

    public String validate(LoginParams loginParams, WarningsCollector warnings) {
        if (isValidCredentials(loginParams.getUsername(), loginParams.getPassword())) {
            return String.format("Welcome %s!", loginParams.getUsername());
        }
        return "User or password are incorrect.";
    }

    private boolean isValidCredentials(String username, String password) {
        return usernameAndPasswords.containsKey(username) &&
                usernameAndPasswords.get(username).equals(password);
    }

}
