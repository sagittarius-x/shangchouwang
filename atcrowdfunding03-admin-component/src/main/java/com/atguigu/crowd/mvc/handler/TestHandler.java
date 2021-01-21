package com.atguigu.crowd.mvc.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.service.api.AdminService;

@Controller
public class TestHandler {
	@Autowired
	private AdminService adminService;
	
	@RequestMapping("/test/ssm.html")
	public String testSsm(ModelMap modelMap) {
		List<Admin> adminList = adminService.getAll();
		modelMap.addAttribute("adminList",adminList);
		return "target";
	}
}
