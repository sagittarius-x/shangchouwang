package com.atguigu.crowd.mvc.config;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.atguigu.crowd.util.CrowdUtil;
import com.atguigu.crowd.util.ResultEntity;
import com.google.gson.Gson;

//@ControllerAdvice 表示该类是一个基于注解的异常处理器类
@ControllerAdvice
public class CrowdExceptionResolver {
    // @ExceptionHandler将一个具体的异常类型和一个方法关联起来
	@ExceptionHandler(value = NullPointerException.class)
	public ModelAndView resolveNullPointerException(NullPointerException exception,
			HttpServletRequest request,
			HttpServletResponse response
			) {
				
		boolean requestType = CrowdUtil.judgeRequestType(request);
		
		if (requestType) {
			ResultEntity<Object> resultEntity = ResultEntity.failed(exception.getMessage());
			Gson gson = new Gson();
			String json = gson.toJson(resultEntity);
			try {
				response.getWriter().write(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("exception", exception);
		modelAndView.setViewName("system-error");
		return modelAndView;
	}
}
