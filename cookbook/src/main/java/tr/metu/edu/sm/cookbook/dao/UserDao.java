package tr.metu.edu.sm.cookbook.dao;

import tr.metu.edu.sm.cookbook.dao.parent.GenericDao;
import tr.metu.edu.sm.cookbook.entity.User;

public interface UserDao extends GenericDao<User, Integer> {
	
	User getUserByEmailAndPassword(String email, String password);
	boolean findUsersWithEmailOrUsername(String email, String username);
}
