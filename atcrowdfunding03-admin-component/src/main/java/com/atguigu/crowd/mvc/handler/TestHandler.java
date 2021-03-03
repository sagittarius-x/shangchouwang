package com.atguigu.crowd.mvc.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.service.api.AdminService;
import com.atguigu.crowd.util.CrowdUtil;

@Controller
public class TestHandler {
	@Autowired
	private AdminService adminService;
	
	private Logger logger = LoggerFactory.getLogger(TestHandler.class);
	
	@ResponseBody
	@RequestMapping("send/array/one.html")
	private String testReceviceJson(@RequestBody List<Integer> array) {	
		for (Integer integer : array) {
			logger.info("number=" + integer);
		}
		return "Success";
	}
	
	@RequestMapping("/send/array.html")
	private String testReceive(@RequestParam("array[]") List<Integer> array) {
		for (Integer number : array) {
			System.out.println(number);
		}
		return "target";
	}
	
	@RequestMapping("/test/ssm.html")
	public String testSsm(ModelMap modelMap, HttpServletRequest request) {
		boolean judgeResult = CrowdUtil.judgeRequestType(request);
		logger.info("judgeResult"+judgeResult);
		
		List<Admin> adminList = adminService.getAll();
		modelMap.addAttribute("adminList",adminList);
		
		return "target";
	}
}
