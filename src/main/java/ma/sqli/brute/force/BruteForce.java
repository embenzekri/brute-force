package ma.sqli.brute.force;

public class BruteForce {
	
	private String login;
	private String passWord;
	private int tries = 0;
	private int triesAndroid = 0;
	private boolean islocked = false;
	private boolean isLockedAndroid = false;
	private boolean isBlackListed = false;
	private boolean isLoggedIn = false;
	BruteForce(String login,String password){
		this.setLogin(login);
		this.setPassWord(password);
	}
	
	
	public int getTries() {
		return tries;
	}
	public void setTries(int tries) {
		this.tries = tries;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public boolean isIslocked() {
		return islocked;
	}
	public void setIslocked(boolean islocked) {
		this.islocked = islocked;
	}
	public boolean isBlackListed() {
		return isBlackListed;
	}
	public void setBlackListed(boolean isBlackListed) {
		this.isBlackListed = isBlackListed;
	}


	public boolean isLoggedIn() {
		return isLoggedIn;
	}


	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}


	public int getTriesAndroid() {
		return triesAndroid;
	}


	public void setTriesAndroid(int triesAndroid) {
		this.triesAndroid = triesAndroid;
	}


	public boolean isLockedAndroid() {
		return isLockedAndroid;
	}


	public void setLockedAndroid(boolean isLockedAndroid) {
		this.isLockedAndroid = isLockedAndroid;
	}
	
}
