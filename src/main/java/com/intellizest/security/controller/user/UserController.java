package com.intellizest.security.controller.user;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.intellizest.security.data.user.User;
import com.intellizest.security.domain.IntelliUser;

@Controller
public class UserController {
	
//	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
		
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
		return "redirect:/";
	}

}
