package com.situ.crm.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.situ.crm.common.DataGrideResult;
import com.situ.crm.entity.User;
import com.situ.crm.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;

	@RequestMapping("/index")
	public String index() {
		return "user_index";
	}
	/*public DataGrideResult<User> pageList() {
		return userService.pageList();
	}*/
	@RequestMapping("/pageList")
	@ResponseBody
	public DataGrideResult pageList(Integer page, Integer rows, User user) {
		 		return userService.pageList(page, rows, user);
		  	}
}
