package homework5.business.abstracts;

import java.util.List;

import homework5.entity.concrete.User;

public interface UserService {
	
	void userAdd(User user);
	void userDelete(User user);
	User getId(int id);
	List<User> getAll();
	boolean checkMailCorrect(String email);
	User getByMail (String email);
	boolean isVerified (User user);
	void verificate(User user);
	
}
