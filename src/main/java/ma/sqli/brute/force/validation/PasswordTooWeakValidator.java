package ma.sqli.brute.force.validation;


public class PasswordTooWeakValidator implements LoginValidator {

    public static final int MIN_LENGTH = 2;

    public String validate(LoginParams loginParams,
                           WarningsCollector warnings) {
        if (loginParams.passwordLengthLowerThan(MIN_LENGTH)) {
            warnings.addWarning("Your password is too weak, please update it by going to your my account.");
        }
        return "";
    }
}
