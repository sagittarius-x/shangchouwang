package com.atguigu.crowd.util;

import javax.servlet.http.HttpServletRequest;

/**
 * 判断当前请求是否为ajax请求
 * @author I506216
 *
 */
public class CrowdUtil {
	public static boolean judgeRequestType(HttpServletRequest request) {
		String acceptHander = request.getHeader("Accept");
		String xRequestHeader = request.getHeader("X-Requested-With");
		
		return (acceptHander != null && acceptHander.contains("application/json")) ||
				(xRequestHeader != null && xRequestHeader.equals("XMLHttpRequest"));
	}
}
