package ma.sqli.brute.force.validation;

public interface LoginValidator {
    String validate(LoginParams loginParams, WarningsCollector warnings);
}
