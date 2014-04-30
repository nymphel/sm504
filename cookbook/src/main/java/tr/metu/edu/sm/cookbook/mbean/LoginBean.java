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
@Qualifier("loginBean")
@Scope("session")
public class LoginBean implements Serializable {
	
	private static Logger logger = Logger.getLogger(LoginBean.class);

	private static final long serialVersionUID = 1L;

	private String email;
	private String password;
	
	private String displayName;

	@Autowired
	private UserService<User, Integer> userService;

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
		User user = userService.getUserByEmailAndPassword(email, GenericUtil.decode(password));
		logger.info("user with email: "+email + " is attempting to login.");
		
		if (user != null) {

			HttpSession session = FacesUtil.getSession();
			session.setAttribute("email", user.getEmail());
			session.setAttribute("id", user.getId());
			
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

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
}