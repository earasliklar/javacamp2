package homework5.business.abstracts;

import homework5.entity.concrete.User;

public interface AuthentucationService {
	
	boolean logIn(User user);
	boolean register(User user);
	boolean logInWithGoogle(User user);
}
