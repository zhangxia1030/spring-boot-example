package com.zx.entity;

public class User {
	private int no;
	
	private String name;
	
	private String message;

	public User(int no, String name, String message) {
		this.no = no;
		this.name = name;
		this.message = message;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "User1 [no=" + no + ", name=" + name + ", message=" + message
				+ "]";
	}
	
}
