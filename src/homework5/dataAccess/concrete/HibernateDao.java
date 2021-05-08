package homework5.dataAccess.concrete;

import java.util.ArrayList;
import java.util.List;

import homework5.dataAccess.abstracts.UserDao;
import homework5.entity.concrete.User;

public class HibernateDao implements UserDao {
	
	private List<User> users;
	private static int lastId;
	
	public  HibernateDao() {
		this.users= new ArrayList<>();
		setLastId(0) ;
	}
	@Override
	public void add(User user) {
		this.users.add(user);
		System.out.println("Kullanýcý Veri Tabanýna Eklandi");
	}

	@Override
	public void delete(User user) {
		int userToDelete = this.users.indexOf(user);
		this.users.remove(userToDelete);
		System.out.println("Kullanýcý Veri Tabanýndan Silindi");
		lastId--;
		
	}


	@Override
	public User get(int id) {
		User userSelected = null;
		for(User user: users) {
			if(user.getId() == id) {
				userSelected = user;
				break;
			}
		}
		return userSelected;
	}

	@Override
	public User getByMail(String email) {
		User userSelected = null;
		for(User user :users) {
			if(user.getEmail().equals(email)) {
				userSelected=user;
				break;
			}
		}
		return userSelected;
	}

	@Override
	public List<User> getAll() {
		return users;
	}

	@Override
	public boolean isVerified(User user) {
		User userCheck = get(user.getId());
		return userCheck.isVerified() ? true: false;
	}

	
	public static int getLastId() {
		return lastId;
	}
	public void setLastId(int lastId) {
		HibernateDao.lastId = lastId;
	}
	

}
