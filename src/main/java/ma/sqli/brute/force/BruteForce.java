package ma.sqli.brute.force;

public class BruteForce {
	
	private String login;
	private String passWord;
	private int tries = 0;
	private boolean islocked = false;
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
	
}
