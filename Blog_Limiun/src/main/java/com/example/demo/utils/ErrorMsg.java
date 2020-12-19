package com.example.demo.utils;


 
public class ErrorMsg  {
	
	private Integer code;
	
	private String msg;
	
	
	public ErrorMsg(int code,String msg) {
		this.msg = msg;
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
