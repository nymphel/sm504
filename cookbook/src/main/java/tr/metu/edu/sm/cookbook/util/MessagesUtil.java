package tr.metu.edu.sm.cookbook.util;

import java.text.MessageFormat;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MessagesUtil {
	
	public static ResourceBundle bundle = ResourceBundle.getBundle("messages");

	public static void setGlobalInfoMessage(String message) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, ""));
	}

	public static void setGlobalErrorMessage(String message) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, ""));
	}
	
	public static void addGlobalErrorMessage(String message) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, ""));
	}

	
	public static void setGlobalWarningMessage(String message) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, message, ""));
	}
	
	public static String getValue(String key) {
		return bundle.getString(key);
	}
	
	public static String getValueParametric(String key, Object[] params) {
		String message = bundle.getString(key);
		return MessageFormat.format(message, params);
	}
	
}
