package com.iorta.sboot.dto;

public class StringData {
	private String letter;
	private String names;
	private int count;
	
	public StringData(String letter, String names, int count) {
		this.letter = letter;
		this.names = names;
		this.count = count;
	}
	
	public String getLetter() {
		return letter;
	}
	
	public String getNames() {
		return names;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setLetter(String letter) {
		this.letter = letter;
	}

	public void setNames(String names) {
		this.names = names;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
}
