package com.atguigu.crowd.mvc.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.crowd.entity.Role;
import com.atguigu.crowd.service.api.RoleService;
import com.atguigu.crowd.util.ResultEntity;
import com.github.pagehelper.PageInfo;
@Controller
public class RoleHandler {

	@Autowired
	RoleService roleService;
	
	@ResponseBody
	@RequestMapping("/role/get/page/info.json")
	public ResultEntity<PageInfo<Role>> getPageInfo(
			@RequestParam(value = "keyword", defaultValue = "") String keyword,
			@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
			@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize
			){
		
		PageInfo<Role> pageInfo = roleService.getPageInfo(pageNum, pageSize, keyword);
		return ResultEntity.successwithData(pageInfo);
	}
	
	@ResponseBody
	@RequestMapping("/role/save.json")
	public ResultEntity<String> saveRole(Role role){
		roleService.saveRole(role);
		return ResultEntity.successwithoutData();
	}
	
	@ResponseBody
	@RequestMapping("/role/update.json")
	public ResultEntity<String> updateRole(Role role){
		roleService.updateRole(role);
		return ResultEntity.successwithoutData();
	}
	
	@ResponseBody
	@RequestMapping("/role/remove/by/role/id/array.json")
	public ResultEntity<String> removeByRoleIdArray(@RequestBody List<Integer> roleIdList){
		roleService.removeRole(roleIdList);
		return ResultEntity.successwithoutData();
	}
}
