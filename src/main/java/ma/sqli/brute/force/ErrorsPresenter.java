package ma.sqli.brute.force;

public class ErrorsPresenter {
	public String BruteForceError() {
		return "Multiple erroneous credentials, your account is locked.";
	}
	
	public String loginFalseError() {
		return "User or password are incorrect.";
	}
	public String blackListedError() {
		return "Your account is blacklisted, contact the CRC to resolve the problem.";
	}
	public String passWordWeakError() {
		return "Your password is too weak, please update it by going to your my account.";
	}

	public String alreadyLoggedInError() {
		return "We detected that your account is logged in multiple devices";
	}
	
}
