package com.intellizest.security.controller.user;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.intellizest.security.data.user.User;
import com.intellizest.security.service.user.UserService;

@Controller
public class UserController {
	
//	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
		
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String goRegister(Locale locale, Model model) {
	//	logger.info("Registration page requested");
		model.addAttribute("user", new User());
		return "register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@ModelAttribute("user") @Valid User user, BindingResult result, Model model) {
	//	logger.info("Registration process started");
		System.out.println("User "+user);
		if(!result.hasErrors()) {
			System.out.println("Before Saving user");
			userService.save(user);
		}
		return "redirect:/";
	}
	
	@RequestMapping(value = "/user/{username}", method = RequestMethod.GET)
	@ResponseBody
	public User user(@PathVariable("username") String username) {
		User user = userService.findByUsername(username);
		System.out.println("User from DB is "+user);
		return user;
	}

}
