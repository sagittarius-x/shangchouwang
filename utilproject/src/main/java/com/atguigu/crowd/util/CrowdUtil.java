package com.atguigu.crowd.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

import com.atguigu.crowd.constant.CrowdConstant;

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
	
	public static String md5(String source) {
		if (source == null || source.length() == 0) {
			throw new RuntimeException(CrowdConstant.MESSAGE_STRING_INVALIDATE);
		}
		
		String algorithm = "md5";
		try {
			MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
			byte[] bytes = source.getBytes();
			byte[] digest = messageDigest.digest(bytes);
			int signum = 1;
			BigInteger bigInteger = new BigInteger(signum, digest);
			int radix = 16;
			String encoded = bigInteger.toString(radix).toUpperCase();	
			return encoded;			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
}
