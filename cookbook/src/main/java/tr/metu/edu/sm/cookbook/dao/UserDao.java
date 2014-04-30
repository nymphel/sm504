package tr.metu.edu.sm.cookbook.dao;

import tr.metu.edu.sm.cookbook.dao.parent.GenericDao;
import tr.metu.edu.sm.cookbook.entity.User;

public interface UserDao extends GenericDao<User, Integer> {
	
	User login(String email, String password);
}
