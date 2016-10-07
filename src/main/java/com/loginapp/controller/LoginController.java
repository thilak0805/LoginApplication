package com.loginapp.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import com.loginapp.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import java.util.Map;
import com.loginapp.form.LoginForm;
import javax.validation.Valid;


@Controller
//@RequestMapping("loginform.html")
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value ="/loginform" ,method=RequestMethod.GET)
	public String showForm(Map model){
		LoginForm loginForm = new LoginForm();
		model.put("loginForm", loginForm);
		return "loginform";
	}
	@RequestMapping(value ="/loginform" ,method=RequestMethod.POST)
	public String processForm(@Valid LoginForm loginForm,BindingResult result,Map model){
		System.out.println("11111111111111");
		if(result.hasErrors()){
			return "loginform";
		}
		boolean userExists = loginService.checkLogin(loginForm.getUserName(), loginForm.getUserPassword());
		if(userExists){
			model.put("loginForm", loginForm);
			return "loginsuccess";
		}else{
			result.rejectValue("userName", "invalidUser");
			return "loginform";
		}
		
	}
	
	

}
