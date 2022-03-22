package ma.sqli.brute.force.validation;

import java.util.Map;

public class LoginValidatorFactory {

    public LoginValidator createValidators(Map<String, String> usernameAndPasswords) {
        CredentialsValidator credentialsValidator = new CredentialsValidator(usernameAndPasswords);

        return credentialsValidator;
    }
}
