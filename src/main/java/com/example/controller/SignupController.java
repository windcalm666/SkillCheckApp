package com.example.controller;

import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.application.service.UserApplicationService;
import com.example.domain.user.model.MUser;
import com.example.domain.user.service.UserService;
import com.example.form.GroupOrder;
import com.example.form.SignupForm;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/user")
@Slf4j
public class SignupController {

	@Autowired
	private UserApplicationService userApplicationService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	/** 新規登録画面の表示 */
	@GetMapping("/signup")
	public String getSignup(Model model, @ModelAttribute SignupForm form) {
		
		Map<String,Integer> genderMap = userApplicationService.getGenderMap();
		model.addAttribute("genderMap",genderMap);
		
		return "user/signup";
	}
	
	/** 新規登録機能 */
	@PostMapping("/signup")
	public String postSignup(Model model, @ModelAttribute @Validated(GroupOrder.class) SignupForm form,
			BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return getSignup(model, form);
		}
		
		MUser user = modelMapper.map(form, MUser.class);
		
		userService.signup(user);
		
		log.info(form.toString());
		
		return "redirect:/user/login";
	}
	
	
}
