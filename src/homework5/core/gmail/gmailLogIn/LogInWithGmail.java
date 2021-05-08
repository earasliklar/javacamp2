package homework5.core.gmail.gmailLogIn;

import java.util.ArrayList;
import java.util.List;

import homework5.core.gmail.gmailUser.GmailUser;


public class LogInWithGmail {
	
	static List<GmailUser> gmailusers;
	
	public LogInWithGmail() {
		gmailusers = new ArrayList<>();
		gmailusers.add(new GmailUser("testName", "testLastName", "testPassword", "testmail@gmail.com"));
			}
	public boolean logIn(String mail, String password) {
		if (gmailFind(mail)!=null && gmailFind(mail).getGmailPassword().equals(password)) {
			return true;
			
		}
        return false;
	}
	private GmailUser gmailFind (String mail) {
		
		GmailUser gmailToReturn = null;
		for(GmailUser gmailUser: gmailusers) {
			if(gmailUser.getGmailMail().equals(mail)) {
				gmailToReturn = gmailUser;
				break;
			}
	
		}
		return gmailToReturn;
		
	
		
	
	}

}
