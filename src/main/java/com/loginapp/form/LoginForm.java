package com.loginapp.form;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class LoginForm implements Serializable {
	@NotEmpty
	@Size(min=1, max=50)
	private String userName;
	@NotEmpty
	@Size(min=1, max=20)
	private String userPassword;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

}
