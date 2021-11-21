package org.serratec.ecommerce.controller.exception;

public class StandardError {

	private Integer status;
	private String msg;
	private Long TimeStamp;
	private String error;
	private String message;
	private String path;

	public StandardError(Integer status, String msg, Long timeStamp) {
		super();
		this.status = status;
		this.msg = msg;
		TimeStamp = timeStamp;
	}

	public StandardError(Long timeStamp, Integer status, String error, String message, String path) {
		super();
		this.TimeStamp = timeStamp;
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}
	
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Long getTimeStamp() {
		return TimeStamp;
	}

	public void setTimeStamp(Long timeStamp) {
		TimeStamp = timeStamp;
	}

}
