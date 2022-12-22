package com.model;

public class BDO {

	private int b_id;                   //pk
	private String b_name;
	private String email;
	private String password;
	private String address;
	private int pincode;
	
	
	public BDO() {
		// TODO Auto-generated constructor stub
	}

	public BDO(int b_id, String b_name, String email, String password, String address, int pincode) {
		super();
		this.b_id = b_id;
		this.b_name = b_name;
		this.email = email;
		this.password = password;
		this.address = address;
		this.pincode = pincode;
		
	}

	public int getB_id() {
		return b_id;
	}

	public void setB_id(int b_id) {
		this.b_id = b_id;
	}

	public String getB_name() {
		return b_name;
	}

	public void setB_name(String b_name) {
		this.b_name = b_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "BDO [b_id=" + b_id + ", b_name=" + b_name + ", email=" + email + ", address=" + address + ", pincode="
				+ pincode + ", password=" + password + "]";
	}
	
	

}
