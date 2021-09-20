package ma.sqli.brute.force.core;

/**
 * @author : El Mahdi Benzekri
 * @since : 9/20/21, lun.
 **/
public enum LoginValidationError {
    PASSWORD_TOO_WEAK,
    MULTIPLE_DEVICES_LOGIN,
    ACCOUNT_BLACKLISTED,
    USER_OR_PASSWORD_ARE_INCORRECT,
    MULTIPLE_ERRONEOUS_CREDENTIALS
}
