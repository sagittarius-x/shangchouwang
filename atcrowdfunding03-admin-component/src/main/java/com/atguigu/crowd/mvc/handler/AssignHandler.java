package com.atguigu.crowd.mvc.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.atguigu.crowd.entity.Role;
import com.atguigu.crowd.service.api.AdminService;
import com.atguigu.crowd.service.api.RoleService;

@Controller
public class AssignHandler {

	@Autowired
	private AdminService adminService;
	@Autowired
	private RoleService roleService;
	
	@RequestMapping("assign/to/assign/role/page.html")
	public String toAssignRolePage(@RequestParam("adminId") Integer adminId,
				ModelMap modelMap
			) {
		List<Role> assignedRoleList = roleService.getAssignedRole(adminId);
		
		List<Role> unassignedRoleList = roleService.getUnassignedRole(adminId);
		
		modelMap.addAttribute("assignedRoleList", assignedRoleList);
		
		modelMap.addAttribute("unAssignedRoleList", unassignedRoleList);
		
		return "assign-role";
	}
	
	@RequestMapping("/assign/do/role/assign.html")
	public String saveRelationship(
			@RequestParam("adminId") Integer adminId,
			@RequestParam("pageNum") Integer pageNum,
			@RequestParam("keyword") String keyword,
			@RequestParam(value="roleIdList", required=false) List<Integer> roleIdList
			) {
		adminService.saveRelationship(adminId, roleIdList);
		
		return "redirect:/admin/get/page.html?pageNum="+pageNum+"&keyword="+keyword;
	}
}
