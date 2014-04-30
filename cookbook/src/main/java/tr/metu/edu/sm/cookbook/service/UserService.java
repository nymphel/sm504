package tr.metu.edu.sm.cookbook.service;

import tr.metu.edu.sm.cookbook.entity.User;

public interface UserService {

	User login(String email, String password);
	void register(User user);
	User getUserByUsername(String username);
	void updateUser(User user);

}
