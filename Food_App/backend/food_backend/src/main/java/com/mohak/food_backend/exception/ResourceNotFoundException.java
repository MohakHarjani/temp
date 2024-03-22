package com.mohak.food_backend.exception;

public class ResourceNotFoundException extends RuntimeException {
	
	private String message;
	public ResourceNotFoundException(String message)
	{
		this.message = message;
	}
	
	@Override
	public String getMessage()
	{
		return this.message;
	}
	public void setMessage(String newMessage)
	{
		this.message = newMessage;
	}

}
