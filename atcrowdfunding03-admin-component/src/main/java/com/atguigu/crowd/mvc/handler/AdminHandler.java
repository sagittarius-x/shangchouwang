package com.atguigu.crowd.mvc.handler;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.atguigu.crowd.constant.CrowdConstant;
import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.service.api.AdminService;

@Controller
public class AdminHandler {

	@Autowired
	private AdminService adminService;
	
	@RequestMapping("/admin/do/login.html")
	public String doLogin(@RequestParam("loginAcct") String loginAcct, 
			@RequestParam("userPswd") String userPswd,
			HttpSession session
			) {
		// 如果返回admin则登录成功 如果账号或密码不正确会抛出异常，该异常会被已经写好的特定异常处理程序处理
		Admin admin = adminService.getAdminByLoginAcct(loginAcct,userPswd);
		
		session.setAttribute(CrowdConstant.ATTR_NAME_LOGIN_ADMIN, admin);
		return "redirect:/admin/to/main/page.html";
	}
	
	@RequestMapping("/admin/do/logout.html")
	public String doLogout(HttpSession session) {
		session.invalidate();
		return "redirect:/admin/to/login/page.html";
	}
	
}
