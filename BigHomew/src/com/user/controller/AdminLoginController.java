package com.user.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.entity.Administrtor;
import com.entity.Order;
import com.entity.Producttype;
import com.user.service.AdminLoginService;

@Controller
@RequestMapping("/admin")
public class AdminLoginController {
	@Resource
	private AdminLoginService adminloginservice;
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(Administrtor admin,Model model){
		System.out.println(admin.getName());
		System.out.println(admin.getPassword());
		List<Administrtor> list=adminloginservice.login(admin.getName());
		if(list.get(0).getPassword().equals(admin.getPassword())){
			List<Producttype> ll=adminloginservice.type();
			List<Order> order=adminloginservice.order();
			model.addAttribute("order",order);
			model.addAttribute("type",ll);
			return "administrator";
		}
		
		return "";
	}
}
