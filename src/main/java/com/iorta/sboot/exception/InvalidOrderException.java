package com.iorta.sboot.exception;

@SuppressWarnings("serial")
public class InvalidOrderException extends RuntimeException{
	public InvalidOrderException(String message) { 
		super(message);
	}
}
