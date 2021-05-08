package homework5.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import homework5.business.abstracts.UserService;
import homework5.dataAccess.abstracts.UserDao;
import homework5.entity.concrete.User;

public class UserManager implements UserService {

	private static final Pattern isValidEmail = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	private UserDao userDao;
	
	
	
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public void userAdd(User user) {
		this.userDao.add(user);
		

	}

	@Override
	public void userDelete(User user) {
		this.userDao.delete(user);
		
	}

	@Override
	public User getId(int id) {
		return this.userDao.get(id);
	}

	@Override
	public List<User> getAll() {
		return this.userDao.getAll();
	}

	@Override
	public boolean checkMailCorrect(String email) {
		Matcher matcher = isValidEmail.matcher(email);
		return matcher.find();
	}

	@Override
	public User getByMail(String email) {
		User userByMail = this.userDao.getByMail(email);
		return userByMail;
		}

	@Override
	public boolean isVerified(User user) {
		boolean userIsVerified = this.userDao.isVerified(user);
		return userIsVerified;
	}

	@Override
	public void verificate(User user) {
		user.setVerified(true);
	}


}
