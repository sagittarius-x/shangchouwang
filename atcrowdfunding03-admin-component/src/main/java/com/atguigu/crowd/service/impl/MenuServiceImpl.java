package com.atguigu.crowd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crowd.mapper.MenuMapper;
import com.atguigu.crowd.service.api.MenuService;
@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuMapper menuMapper;
}
