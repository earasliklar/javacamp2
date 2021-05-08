package homework5.core.gmail.services;

import homework5.core.gmail.gmailLogIn.LogInWithGmail;

public class LogInWithGmailAdapter implements LogInWithGmailService {

	@Override
	public boolean login(String mail, String password) {
		
		LogInWithGmail logInWithGmail = new LogInWithGmail();
		
		return logInWithGmail.logIn(mail, password);
	}

}
