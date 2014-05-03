package tr.metu.edu.sm.cookbook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.metu.edu.sm.cookbook.dao.UserDao;
import tr.metu.edu.sm.cookbook.dao.parent.GenericDao;
import tr.metu.edu.sm.cookbook.entity.User;
import tr.metu.edu.sm.cookbook.service.parent.GenericServiceImpl;

@Service(value = "userService")
public class UserServiceImpl extends
		GenericServiceImpl<User, Integer> implements
		UserService<User, Integer> {

	@Autowired
	private UserDao dao;

	@Override
	public GenericDao<User, Integer> getDao() {
		return this.dao;
	}

	@Override
	public User getUserByEmailAndPassword(String email, String password) {
		return dao.getUserByEmailAndPassword(email, password);
	}

	@Override
	public boolean findUsersWithEmailOrUsername(String email, String username) {
		// TODO Auto-generated method stub
		return false;
	}

}
