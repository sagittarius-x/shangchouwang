package com.atguigu.crowd.mvc.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.service.api.AdminService;

@Controller
public class TestHandler {
	@Autowired
	private AdminService adminService;
	
	@RequestMapping("/send/array.html")
	private String testReceive(@RequestParam("array[]") List<Integer> array) {
		for (Integer number : array) {
			System.out.println(number);
		}
		return "target";
	}
	
	@RequestMapping("/test/ssm.html")
	public String testSsm(ModelMap modelMap) {
		List<Admin> adminList = adminService.getAll();
		modelMap.addAttribute("adminList",adminList);
		return "target";
	}
}
