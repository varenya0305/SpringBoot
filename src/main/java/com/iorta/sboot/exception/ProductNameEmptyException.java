package com.iorta.sboot.exception;

@SuppressWarnings("serial")
public class ProductNameEmptyException extends RuntimeException{
	public ProductNameEmptyException(String message) {
		super(message);
	}

}
