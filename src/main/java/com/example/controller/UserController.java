package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.user.model.MUser;
import com.example.domain.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	/** トップページの表示 */
	@GetMapping("/top")
	public String getTop(Model model) {
		List<MUser> userList = userService.getUsers();
		model.addAttribute("userList",userList);
		return "/user/top";
	}
	
	/** ログイン画面の表示 */
	@GetMapping("/login")
	public String getLogin() {
		return "login/login";
	}
}
