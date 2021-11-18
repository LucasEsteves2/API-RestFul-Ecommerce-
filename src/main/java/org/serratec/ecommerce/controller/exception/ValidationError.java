package org.serratec.ecommerce.controller.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

	public ValidationError(Integer status, String msg, Long timeStamp) {
		super(status, msg, timeStamp);
		// TODO Auto-generated constructor stub
	}
	private List<FieldMessage> list = new ArrayList<>();

	public List<FieldMessage> getErro() {
		return list;
	}

	
	public void addError(String fieldname, String messagem)
	{
	
		list.add(new FieldMessage(fieldname,messagem));
	}
	
	
	
}
