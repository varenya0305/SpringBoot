package com.iorta.sboot.dto;

public class OrderDTO {
	private int orderId;
	private String productName;
	private UserDTO user;
	
	public OrderDTO() {}
	
	public OrderDTO(int orderId, String productName, UserDTO user) {
		this.orderId = orderId;
		this.productName = productName;
		this.user = user;
	}

	public int getOrderId() {
		return orderId;
	}
	public String getProductName() {
		return productName;
	}
	public UserDTO getUser() {
		return user;
	}
}
