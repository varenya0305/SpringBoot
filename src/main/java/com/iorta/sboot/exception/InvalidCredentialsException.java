package com.iorta.sboot.exception;

@SuppressWarnings("serial")
public class InvalidCredentialsException extends RuntimeException {
	public InvalidCredentialsException(String message) {
		 super(message);
	}

}
