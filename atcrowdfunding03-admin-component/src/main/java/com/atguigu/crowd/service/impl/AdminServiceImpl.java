package com.atguigu.crowd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.mapper.AdminMapper;

@Service
public class AdminServiceImpl implements com.atguigu.crowd.service.api.AdminService {
	
	@Autowired
	private AdminMapper adminMapper;
	
	@Override
	public void saveAdmin(Admin admin) {
		adminMapper.insert(admin);
		throw new RuntimeException();
	}

}
