package ma.sqli.brute.force;

public class ErrorsPresenter {
	public String BruteForceError() {
		return "Multiple erroneous credentials, your account is locked.";
	}
	
	public String loginFalseError() {
		return "User or password are incorrect.";
	}
	
}
