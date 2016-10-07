package com.loginapp.controller;

import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.loginapp.form.UserForm;
import com.loginapp.model.UserDetails;
import com.loginapp.service.AddUserService;
import com.loginapp.service.AddUserServiceImpl;

import org.springframework.validation.BindingResult;

import javax.swing.plaf.synth.SynthSeparatorUI;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class AddUserController {
	// private static final Logger logger =
	// Logger.getLogger(AddUserController.class);
	@Autowired
	private AddUserService adduserservice;

	@RequestMapping(value = "/addusers", method = RequestMethod.GET)
	public String showUserForm(Map model) {
		System.out.println("aaaaaaaaaa");
		UserForm addUsers = new UserForm();
		model.put("addusers", addUsers);
		return "addusers";
	}

	@RequestMapping(value = "/showusers", method = RequestMethod.GET)
	public ModelAndView userList(@ModelAttribute("showusers1") UserDetails userdetails) {
		System.out.println("userList .........");
		ModelAndView modelandview = new ModelAndView();
		System.out.println("1111111>>>> " + adduserservice.getUsers());
		modelandview.addObject("listUsers", adduserservice.getUsers());
		modelandview.setViewName("showusers");
		return modelandview;
	}

	@RequestMapping(value = "/addusers", method = RequestMethod.POST)
	public String processUserForm(@Valid UserForm userForm, BindingResult result, Map model) {
		System.out.println("2222222");
		boolean userInserted = false;
		/*if (result.hasErrors()) {
			System.out.println("333333");
			return "addusers";
		}*/
		userInserted = adduserservice.checkAddUsers(userForm.getUserId(), userForm.getUserFirstName(),
				userForm.getUserLastName(), userForm.getUserAddress(), userForm.getUserMobile());

		System.out.println("22222" + userInserted);
		if (userInserted) {
			return "showusers";
		} else {
			result.rejectValue("userdet", "User Not Added");
			return "addusers";
		}

	}

	@RequestMapping(value = "/addusers/{id}/update", method = RequestMethod.GET)
	public String editPerson(@PathVariable("id") int id, Model model) {
		System.out.println("inside edit person method.....");
		model.addAttribute("addusers", adduserservice.getPersonById(id));
		model.addAttribute("listPersons", adduserservice.getUsers());
		return "addusers";
	}

	@RequestMapping(value = "/addusers/{id}/addusers.html", method = RequestMethod.POST)
	public String editPersonValue(@PathVariable("id") int id, Model model, @Valid UserForm userForm) {
		System.out.println("inside controller....editPersonValue....");
		boolean userUpdated = false;
		userUpdated = adduserservice.updateUsersById(id, userForm.getUserFirstName(), userForm.getUserLastName(),
				userForm.getUserAddress(), userForm.getUserMobile());
		if (userUpdated) {
			return "showusers";
		} else {
			return "redirect:addusers";
		}
		 
	}
}
