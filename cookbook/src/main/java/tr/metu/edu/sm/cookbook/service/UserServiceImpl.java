package tr.metu.edu.sm.cookbook.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.metu.edu.sm.cookbook.dao.UserDao;
import tr.metu.edu.sm.cookbook.entity.User;


@Service(value = "userService")
public class UserServiceImpl implements UserService, Serializable {

	private static final long serialVersionUID = -5023473254969455231L;
	
	@Autowired
    private UserDao userDao;
	
	
	public UserServiceImpl() {

	}

	@Override
	public User login(String email, String password) {
		return userDao.login(email, password);
	}

	@Override
	public void register(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

}
