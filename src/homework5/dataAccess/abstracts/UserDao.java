package homework5.dataAccess.abstracts;

import java.util.List;

import homework5.entity.concrete.User;

public interface UserDao {
	
	void add(User user);
	void delete(User user);
	User get(int id);
	User getByMail(String email);
	List<User> getAll();
	boolean isVerified(User user);

}
