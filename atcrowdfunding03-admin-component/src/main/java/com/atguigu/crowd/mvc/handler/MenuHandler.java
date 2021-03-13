package com.atguigu.crowd.mvc.handler;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.crowd.entity.Menu;
import com.atguigu.crowd.service.api.MenuService;
import com.atguigu.crowd.util.ResultEntity;

//@Controller
@RestController
public class MenuHandler {
	@Autowired
	MenuService menuService;
	
	@ResponseBody
	@RequestMapping("/menu/get/whole/tree.json")
	public ResultEntity<Menu> getWholeTreeNew(){
		
		List<Menu> menuList = menuService.getAll();
		
		Menu root = null;
		
		Map<Integer, Menu> menuMap = new HashMap<>();
	    for (Menu menu : menuList) {
			Integer id = menu.getId();
			menuMap.put(id, menu);
		}
		
	    for (Menu menu : menuList) {
			Integer pid = menu.getPid();
			
			if (pid == null) {
				root = menu;
				continue;
			}
			Menu father = menuMap.get(pid);
			father.getChildren().add(menu);
		}
		return ResultEntity.successwithData(root);
	}

//	@ResponseBody
	@RequestMapping("/menu/save.json")
	public ResultEntity<String> saveMenu(Menu menu){
		
		menuService.saveMenu(menu);
		
		return ResultEntity.successwithoutData();
	}
	
//	@ResponseBody
	@RequestMapping("/menu/update.json")
	public ResultEntity<String> updateMenu(Menu menu){
		
		menuService.updateMenu(menu);
		return ResultEntity.successwithoutData();
	}
	
//	@ResponseBody
	@RequestMapping("/menu/remove.json")
	public ResultEntity<String> removeMenu(@RequestParam("id") Integer id){
		menuService.removeMenu(id);
		return ResultEntity.successwithoutData();
	}
}
