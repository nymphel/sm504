package tr.metu.edu.sm.cookbook.mbean;

import java.io.Serializable;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import tr.metu.edu.sm.cookbook.entity.User;
import tr.metu.edu.sm.cookbook.service.UserService;
import tr.metu.edu.sm.cookbook.util.FacesUtil;
import tr.metu.edu.sm.cookbook.util.GenericUtil;
import tr.metu.edu.sm.cookbook.util.MessagesUtil;


@Component
@Qualifier("userBean")
@Scope("session")
public class UserBean implements Serializable {
	
	private static Logger logger = Logger.getLogger(UserBean.class);

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private UserService<User, Integer> userService;
	
	private User user = new User();

	private String email;
	private String password;
	
	private String displayName;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String login() {
		User user = userService.getUserByEmailAndPassword(email, GenericUtil.encode(password));
		logger.info("user with email: "+email + " is attempting to login.");
		
		if (user != null) {

			HttpSession session = FacesUtil.getSession();
			session.setAttribute("email", user.getEmail());
			session.setAttribute("id", user.getId());
			session.setAttribute("user", user);
			
			this.displayName = user.getUsername();
			
			logger.info("SUCCESSFUL. Logging the user into system now...");

			return "index";
		} else {

			MessagesUtil.setGlobalWarningMessage(MessagesUtil.getValue("invalidLogin"));
			logger.info("No user found with given credentials. ACCESS RESTRICTED.");
			return "login";
		}
	}

	public String logout() {
		HttpSession session = FacesUtil.getSession();
		session.invalidate();
		MessagesUtil.setGlobalInfoMessage(MessagesUtil
				.getValue("logoutSuccessful"));
		
		return "login";
	}
	
	public String register() 
	{
		if(!isUniqueEmailAndUsername())
		{
			MessagesUtil.setGlobalWarningMessage(MessagesUtil.getValue("invalidRegister"));
			logger.info("User found with given credentials.");
			return "";
		}
		
		user.setPassword(GenericUtil.encode(user.getPassword()));
		
		userService.create(user);
		
		return "login";
	}
	
	public void update() {
		
	}
	
	public boolean isUniqueEmailAndUsername() 
	{
		if(userService.findUsersWithEmailOrUsername(user.getEmail(), user.getPassword()))
			return false;
		return true;
	}
	
	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}