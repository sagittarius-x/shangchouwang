package com.atguigu.crowd.util;

/**
 * 统一整个项目中Ajax请求返回的结果（未来也可以用来分布式架构各个模块间调用时的返回）
 * @author I506216
 *
 * @param <T>
 */
public class ResultEntity<T> {

	public static final String SUCCESS = "SUCCESS";
	public static final String FAILED = "FAILED";
	private String result;
	
	private String message;

	private T data;
	
	public static <E> ResultEntity<E> successwithoutData() {
		return new ResultEntity<E>(SUCCESS, null, null);
	}
	
	public static <E> ResultEntity<E> successwithData(E data) {
		return new ResultEntity<E>(SUCCESS,null,data);
	}
	
	public static <E> ResultEntity<E> failed(String message) {
		return new ResultEntity<E>(FAILED, message, null);
	}
	
	@Override
	public String toString() {
		return "ResultEntity [result=" + result + ", message=" + message + ", data=" + data + "]";
	}

	public ResultEntity(String result, String message, T data) {
		super();
		this.result = result;
		this.message = message;
		this.data = data;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
