package homework5.core.gmail.gmailUser;

public class GmailUser {
	
	private String gmailFirstName;
	private String gmailLastName;
	private String gmailPassword;
	private String gmailMail;
	
	public GmailUser(String gmailFirstName, String gmailLastName, String gmailPassword, String gmailMail) {
		super();
		this.gmailFirstName = gmailFirstName;
		this.gmailLastName = gmailLastName;
		this.gmailPassword = gmailPassword;
		this.gmailMail = gmailMail;
	}

	public String getGmailFirstName() {
		return gmailFirstName;
	}

	public void setGmailFirstName(String gmailFirstName) {
		this.gmailFirstName = gmailFirstName;
	}

	public String getGmailLastName() {
		return gmailLastName;
	}

	public void setGmailLastName(String gmailLastName) {
		this.gmailLastName = gmailLastName;
	}

	public String getGmailPassword() {
		return gmailPassword;
	}

	public void setGmailPassword(String gmailPassword) {
		this.gmailPassword = gmailPassword;
	}

	public String getGmailMail() {
		return gmailMail;
	}

	public void setGmailMail(String gmailMail) {
		this.gmailMail = gmailMail;
	}
	
	

}
