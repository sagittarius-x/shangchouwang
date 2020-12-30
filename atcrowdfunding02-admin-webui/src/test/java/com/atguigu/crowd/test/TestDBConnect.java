package com.atguigu.crowd.test;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.mapper.AdminMapper;
import com.atguigu.crowd.service.api.AdminService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-persist-mybatis.xml", 
		"classpath:spring-persist-tx.xml"})
public class TestDBConnect {
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private AdminMapper adminMapper;
	
	@Autowired
	private AdminService adminService;
	
	@Test
	public void testTx() {
		Admin admin = new Admin(null,"jerry","123123","桃木","tom@qq.com",null);
		adminService.saveAdmin(admin);
	}
	
	@Test
	public void testLog() {
		// 获取logger对象,传入的class对象是当前打印日志的类
		Logger logger = LoggerFactory.getLogger(TestDBConnect.class);
		
		// 根据不同日志级别打印日志
		logger.debug("debug level");
		logger.info("info level");
		logger.warn("warn level");
		logger.error("error level");
	}
	
	@Test
	public void testConnection() throws SQLException{
		Connection connection =  dataSource.getConnection();
		System.out.println(connection);
	}
	
	@Test
	public void testInsert() {
		Admin admin = new Admin(null,"tom","123123","桃木","tom@qq.com",null);
		int count = adminMapper.insert(admin);
		System.out.println(count);
	}
}
