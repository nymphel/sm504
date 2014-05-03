package tr.metu.edu.sm.cookbook.service;

import tr.metu.edu.sm.cookbook.entity.User;
import tr.metu.edu.sm.cookbook.service.parent.GenericService;

public interface UserService<E, K> extends GenericService<E, K> {

	User getUserByEmailAndPassword(String email, String password);
	boolean findUsersWithEmailOrUsername(String email, String username);

}
